package com.geek.csdngeek;

import android.app.Application;

import com.geek.csdngeek.utils.CrashHandler;

/**
 * @Author:morse
 * @Time:2017/9/16 15:41
 * @Description:
 */
public class GeekApplication extends Application {

    public static GeekApplication mIntance;

    @Override
    public void onCreate() {
        super.onCreate();
        mIntance = this;
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(this);
    }

    public static GeekApplication getInstance() {
        return null == mIntance ? null : mIntance;
    }
}
