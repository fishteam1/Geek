package com.morse.mvplibrary.ui;

import com.morse.mvplibrary.mvp.BaseContract;

/**
 * Created by admin on 2018/4/27.
 */

public interface MVPCallBack<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>> {

    /**
     * 创建Presenter
     *
     * @return
     */
    P createPresenter();

    /**
     * 获取Presenter
     *
     * @return
     */
    P getPresenter();

    /**
     * 设置Presenter
     *
     * @param p
     */
    void setPresenter(P p);

    /**
     * 获取View
     *
     * @return
     */
    V getMVPView();

}
