package com.geek.csdngeek.mvp;

import android.app.Activity;

import com.geek.csdngeek.ui.base.BaseActivity;

import java.lang.ref.WeakReference;

/**
 * @Author:曾明
 * @Time:2017/9/16 16:07
 * @Description:
 */
public class BPreView {
    WeakReference<Object> weakContext;

    public BPreView(Object object) {
        weakContext = new WeakReference<Object>(object);
    }

    public static boolean isAlive(BPreView presView) {
        if (presView == null) {
            return false;
        }
        return presView.isAlive();
    }

    public void onGetPartnerInfoSuccess() {

    }

    public void onGetPartnerInfoFailure(int code, String msg) {

    }

    public boolean isAlive() {
        if (weakContext == null || weakContext.get() == null) {
            return false;
        }
        try {
            Object object = weakContext.get();
            if (object instanceof BaseActivity || object instanceof Activity) {
                Activity activity = (Activity) object;
                if (activity.isFinishing()) {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Object getWeakObject() {
        if (weakContext == null || weakContext.get() == null) {
            return null;
        }
        return weakContext.get();
    }
}
