package org.blackist.common.util.http.okhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.blackist.common.util.format.date.DateDeserializer;
import org.blackist.common.util.format.date.DateSerializer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/17
 */

public class RetrofitUtils {

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(java.util.Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG)
            .registerTypeAdapter(java.util.Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG)
            .create();

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    public static Retrofit getRetrofit(String url) {

        //Retrofit2 Builder
        return new Retrofit.Builder()
                // Server BaseURL
                .baseUrl(url)
                // 一定要在gsonConverter前面,否则gson会拦截所有的解析方式
                .addConverterFactory(NobodyConverterFactory.create())
                // Gson Converter
                .addConverterFactory(GsonConverterFactory.create(gson))
                // Callback Handler RxJava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                // Set OkHttp
                .client(OkHttp3Util.getOkHttpClient())
                .build();
    }

    /**
     * 代替gson converter转换无响应体的response
     */
    public static class NobodyConverterFactory extends Converter.Factory {

        public static final NobodyConverterFactory create() {
            return new NobodyConverterFactory();
        }

        private NobodyConverterFactory() {
        }

        //将响应对象responseBody转成目标类型对象(也就是Call里给定的类型)
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            //判断当前的类型是否是我们需要处理的类型
            if (Response.class.equals(type)) {
                //是则创建一个Converter返回转换数据
                return new Converter<ResponseBody, Response>() {
                    @Override
                    public Response convert(ResponseBody value) throws IOException {
                        //这里直接返回null是因为我们不需要使用到响应体,本来也没有响应体.
                        //返回的对象会存到response.body()里.
                        return null;
                    }
                };
            }
            return null;

        }

        //其它两个方法我们不需要使用到.所以不需要重写.
        @Override
        public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
            return null;
        }

        @Override
        public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            return null;
        }
    }
}
