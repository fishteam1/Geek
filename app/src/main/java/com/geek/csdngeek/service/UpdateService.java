package com.geek.csdngeek.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 更新app service
 *
 * @Author:曾明
 * @Time:2017/9/16 15:54
 * @Description:
 */
public class UpdateService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
