package com.morse.mvplibrary.ui.fragment;

/**
 * Created by admin on 2018/4/27.
 */

public interface FragmentDelegate {

    /**
     * 创建是Fragment
     */
    void onCreateView();

    /**
     * 视图Fragment
     */
    void onDestroy();
}
