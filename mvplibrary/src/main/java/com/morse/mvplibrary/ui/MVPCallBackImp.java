package com.morse.mvplibrary.ui;

import com.morse.mvplibrary.mvp.BaseContract;

/**
 * Created by admin on 2018/4/27.
 */
public class MVPCallBackImp<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>> implements MVPCallBack<V, P> {

    private MVPCallBack<V, P> mvpCallBack;

    public MVPCallBackImp(MVPCallBack<V, P> callBack) {
        if (null == callBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        mvpCallBack = callBack;
    }

    @Override
    public P createPresenter() {
        if (null == mvpCallBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        P presenter = mvpCallBack.getPresenter();
        if (null == presenter) {
            presenter = mvpCallBack.createPresenter();
        }
        if (null == presenter) {
            throw new NullPointerException("presenter is null");
        }
        setPresenter(presenter);
        return getPresenter();
    }

    @Override
    public P getPresenter() {
        if (null == mvpCallBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        if (null == mvpCallBack.getPresenter()) {
            throw new NullPointerException("presenter is null");
        }
        return mvpCallBack.getPresenter();
    }

    @Override
    public void setPresenter(P p) {
        if (null == p) {
            throw new NullPointerException("presenter is null");
        }
        mvpCallBack.setPresenter(p);
    }

    @Override
    public V getMVPView() {
        if (null == mvpCallBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        if (null == mvpCallBack.getMVPView()) {
            throw new NullPointerException("IView is null");
        }
        return mvpCallBack.getMVPView();
    }

    public void attach() {
        if (null == mvpCallBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        if (null == mvpCallBack.getPresenter()) {
            throw new NullPointerException("presenter is null");
        }
        if (null == mvpCallBack.getMVPView()) {
            throw new NullPointerException("IView is null");
        }
        mvpCallBack.getPresenter().attachView(mvpCallBack.getMVPView());
    }

    public void dettach() {
        if (null == mvpCallBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        if (null == mvpCallBack.getPresenter()) {
            throw new NullPointerException("presenter is null");
        }
        mvpCallBack.getPresenter().dettachView();
    }
}
