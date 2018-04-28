package com.morse.mvplibrary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.morse.mvplibrary.mvp.BaseContract;
import com.morse.mvplibrary.ui.MVPCallBack;

/**
 * Created by admin on 2018/4/27.
 */
public abstract class MVPFragment<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>>
        extends Fragment implements BaseContract.IView, MVPCallBack<V, P> {

    private P mPresenter;
    private FragmentDelegateImp<V, P> delegate;

    private FragmentDelegateImp<V, P> getDelegateImp() {
        if (null == delegate) {
            delegate = new FragmentDelegateImp<>(this);
        }
        return delegate;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDelegateImp().onCreateView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getDelegateImp().onDestroy();
    }
}
