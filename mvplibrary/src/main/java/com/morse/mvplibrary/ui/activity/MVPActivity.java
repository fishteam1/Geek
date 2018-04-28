package com.morse.mvplibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.morse.mvplibrary.mvp.BaseContract;
import com.morse.mvplibrary.ui.MVPCallBack;

/**
 * Created by admin on 2018/4/27.
 */
public abstract class MVPActivity<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>>
        extends AppCompatActivity implements BaseContract.IView, MVPCallBack<V, P> {

    private P mPresenter;
    private ActivityDelegateImp<V, P> delegateImp;

    private ActivityDelegateImp<V, P> getDelegateImp() {
        if (null == delegateImp) {
            delegateImp = new ActivityDelegateImp<>(this);
        }
        return delegateImp;
    }

    @Override
    public P createPresenter() {
        return mPresenter;
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(P p) {
        mPresenter = p;
    }

    @Override
    public V getMVPView() {
        return (V) this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDelegateImp().onCreate();
    }

    @Override
    protected void onDestroy() {
        getDelegateImp().onDestroy();
        super.onDestroy();
    }
}
