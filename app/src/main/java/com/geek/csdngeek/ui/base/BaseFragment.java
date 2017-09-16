package com.geek.csdngeek.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 实现懒加载fragment基类
 *
 * @Author:曾明
 * @Time:2017/9/16 15:27
 * @Description:
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mView;
    protected boolean isVisible;
    protected boolean isPrepared = false;
    private Unbinder unbinder;

    /**
     * 初始化UI
     *
     * @return
     */
    protected abstract View initLayout(LayoutInflater inflater, ViewGroup container);

    /**
     * 初始化数据前处理
     */
    protected void beforeView() {
    }

    /**
     * 初始化数据
     */
    protected abstract void afterView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();//防止在fragment弹出toast的时候报空指针异常
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            mView = initLayout(inflater, container);
            unbinder = ButterKnife.bind(this, mView);
            isPrepared = true;
            lazyLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mView;
    }

    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        } else {
            beforeView();
            afterView();
        }
    }

    protected void onInvisible() {
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
