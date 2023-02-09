![](https://blogres.blackist.org/android-modulize-logo-readmes.png)


<!-- <h1 style="text-align:center"> Modulize </h1>  -->

Android项目模块化开发，包括：

- 基础库搭建、公共库抽离、业务层分割
- 自定义组件间通信框架BRouter
- UI风格统一并实现主题切换
- MVP设计模式
- 多渠道推送集成，包括消息去重设计
- 服务器长连接的模块化设计


### BRouter 

BRouter是自定义的组件间通信框架，简洁易用，与业务代码高度解耦，且适用于多进程的情况，参见[BRouter](https://github.com/blackist/BRouter)


### 风格统一主题切换

客户端开发中UI设计极其重要，直接影响用户体验和App的品质；其次UI设计应做到样式、排版统一，简化布局文件，方便全局修改和维护。参见[UI统一&主题变色](https://blackist.org/2019/03/21/android-modulize-ui-theme/)

![](https://blogres.blackist.org/android-modulize-ui-theme-alertdialog-nal.png)

切换主题后：

![](https://blogres.blackist.org/android-modulize-ui-theme-alertdialog.png)

### Push
---

首先集成[极光推送](https://www.jiguang.cn/)，具体操作参考[极光推送Android SDK集成指南](https://docs.jiguang.cn/jpush/client/Android/android_guide/)。我们要做到推送服务与业务代码隔离，在lib-push库中处理推送逻辑，对外暴露一个推送服务初始化接口，以及推送通知接口，具体实现如下。

#### 推送初始化

新建PushClient类，使用单例模式，这是对外提供服务的工具类，包含推送初始化、别名设置、通知接口设置。

``` java
public class PushClient {

	// 推送通知回调，回调给业务层
    PushListener mListener;

    public static PushClient getInstance() {
        // 单例模式
		...

        return instance;
    }

    /**
     * Push init
     *
     * @param context context
     * @return
     */
    public PushClient init(Context context) {
        this.mContext = context;
        JPushInterface.setDebugMode(true);
        JPushInterface.init(mContext);

		// 其它推送
		...

        return PushClient.this;
    }

    /**
     * set push alias
     *
     * @param alias alias
     */
    public PushClient setAlias(String alias) {
        JPushInterface.setAlias(mContext, new Random().nextInt(), alias);
        ...

        return PushClient.this;
    }

    /**
     * set push listener to receive message
     *
     * @param listener
     * @return
     */
    public PushClient setListener(PushListener listener) {
        this.mListener = listener;

        return PushClient.this;
    }
}

```

#### 推送回调

PushListener为回调接口，业务层实现此接口，当推送服务收到推送，会在接收器里回调此实现，

``` java
@Override
public void onReceive(Context context, Intent intent) {
    try {
        Bundle bundle = intent.getExtras();
        Log.d(TAG, "[JPush]: onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));
		...
        
        if (PushClient.getInstance().mListener != null) {
            PushClient.getInstance().mListener.onPush(context, content);
        }
        
		...
    } catch (Exception e) {

    }

}

```

当业务层接收到推送后，可进行具体而复杂的处理。

#### 多通道推送

实际开发中，遇到小米推送不及时、偶发性推送失效的场景，解决方案是集成2-3个推送通道，本项目集成了小米、极光推送，小米推送集成参见[小米推送Android客户端SDK使用指南](https://dev.mi.com/console/doc/detail?pId=41)，和极光推送一样，都配置在lib-push中，与上层逻辑隔离，集成时请留意权限配置。小米推送依然在PushClinet中初始化，别名设置也在setAlias()方法中。

此时迎来第二个问题，多通道推送必然导致消息重复，需要对收到的推送进行过滤，也正式因此，消息推送最好采用自定义消息（小米称透传消息）的方式推送，方便客户端进行消息过滤以及自定义通知栏。


#### 消息去重

在消息到达客户端的时候，不再直接回调业务层接口实现，应该先进行消息处理，确认消息不重复之后再进行回调通知，加入PushManage消息处理类，

``` java
public void onReceive(Context context, Intent intent) {
    try {
        Bundle bundle = intent.getExtras();
        Log.d(TAG, "[JPush]: onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));
		...
        // 处理消息 进行消息去重、数据库存储
        PushManage.push(context, content);
        
		...
    } catch (Exception e) {

    }

}

``` 

PushManage对消息进行过滤，并存储到数据库，重启App以后仍然可对消息进行有效过滤，防止推送延迟严重的现象。
