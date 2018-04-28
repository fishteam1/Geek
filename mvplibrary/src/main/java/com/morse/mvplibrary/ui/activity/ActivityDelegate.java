package com.morse.mvplibrary.ui.activity;

/**
 * Created by admin on 2018/4/27.
 */

public interface ActivityDelegate {

    /**
     * 创建Activity
     */
    void onCreate();

    /**
     * Activity销毁
     */
    void onDestroy();

}
