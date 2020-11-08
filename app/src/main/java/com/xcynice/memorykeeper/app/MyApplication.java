package com.xcynice.memorykeeper.app;


import android.app.Application;
import android.content.Context;

import com.didichuxing.doraemonkit.DoraemonKit;

import java.util.concurrent.TimeUnit;

import ren.yale.android.retrofitcachelibrx2.RetrofitCache;

/**
 * @Author 许朋友爱玩
 * @Date 2020/7/27 16:51
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description MyApplication 全局
 */

public class MyApplication extends Application {
    /**
     * 对外提供整个应用生命周期的Context
     **/
    private static Context instance;


    /**
     * 对外提供Application Context
     *
     * @return
     */
    public static Context gainContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //开启性能检测
        DoraemonKit.install(this, "4c1a9451268716a4fdabfd22eb026357");
        //初始化
//        XUtil.initialize(this);
        //初始化缓存，并设置缓存时间为一天
        RetrofitCache.getInstance().init(this).setDefaultTimeUnit(TimeUnit.DAYS).setDefaultTime(1);
        //设置打印开关
//        LogUtil.setIsLog(true);
        instance = this;
        //注册Activity生命周期
//        registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());

    }
}
