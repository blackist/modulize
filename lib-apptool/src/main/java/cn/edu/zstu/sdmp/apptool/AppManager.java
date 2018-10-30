package cn.edu.zstu.sdmp.apptool;

import android.app.Activity;
import android.os.Process;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author LiangLiang.Dong<liangl.dong@qq.com>
 * @since 2018/10/12
 */

public class AppManager {

    private static final String TAG = "AppManager";

    private volatile static AppManager instance;
    private Stack<WeakReference<Activity>> activityStack;

    private AppManager() {
        activityStack = new Stack<>();
    }

    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * get stack
     *
     * @return
     */
    public Stack<WeakReference<Activity>> getStack() {
        return activityStack;
    }

    /**
     * get stack size
     *
     * @return
     */
    public int stackSize() {
        return activityStack == null ? 0 : activityStack.size();
    }

    /**
     * add activity to stack
     */
    public void addActivity(WeakReference<Activity> activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * remove activity
     *
     * @param activity
     */
    public void removeActivity(WeakReference<Activity> activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * @param activity
     */
    public void killActivity(WeakReference<Activity> activity) {
        try {
            ListIterator<WeakReference<Activity>> iterator = activityStack.listIterator();
            while (iterator.hasNext()) {
                WeakReference<Activity> a = iterator.next();
                if (a.get() == null) {
                    iterator.remove();
                    continue;
                }
                if (a.get().getClass().getName().equals(activity.get().getClass().getName())) {
                    iterator.remove();
                    a.get().finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * kill activity by class
     *
     * @param cla
     */
    public void killActivity(Class<?> cla) {
        try {
            ListIterator<WeakReference<Activity>> iterator = activityStack.listIterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next().get();
                if (activity != null && activity.getClass() == cla) {
                    activity.finish();
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * kill all activity
     */
    public void killAllActivity() {
        try {
            Iterator<WeakReference<Activity>> iterator = activityStack.iterator();
            while (iterator.hasNext()) {
                WeakReference<Activity> a = iterator.next();
                if (a.get() != null) {
                    a.get().finish();
                }
                iterator.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * recreate all activity
     */
    public void recreateAllActivity() {
        try {
            Iterator<WeakReference<Activity>> iterator = activityStack.iterator();
            while (iterator.hasNext()) {
                WeakReference<Activity> a = iterator.next();
                a.get().recreate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * app exit
     */
    public void exit() {
        try {
            killAllActivity();
            Process.killProcess(Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
