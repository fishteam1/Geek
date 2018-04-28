package com.morse.mvplibrary.ui.lce;

import android.view.View;

import com.morse.mvplibrary.R;
import com.morse.mvplibrary.ui.lce.animator.DefaultLceAnimator;
import com.morse.mvplibrary.ui.lce.animator.ILceAnimator;

/**
 * Created by admin on 2018/4/27.
 */
public class LceViewImp<M> implements LceView<M> {
    private View loadingView;
    private View contentView;
    private View errorView;

    private ILceAnimator lceAnimator;

    /**
     * 初始化视图
     *
     * @param v
     */
    public void initLceView(View v) {
        if (loadingView == null) {
            loadingView = v.findViewById(R.id.loadingView);
        }
        if (contentView == null) {
            contentView = v.findViewById(R.id.contentView);
        }
        if (errorView == null) {
            errorView = v.findViewById(R.id.errorView);
        }
        if (loadingView == null) {
            throw new NullPointerException("loadingView is not null!");
        }
        if (contentView == null) {
            throw new NullPointerException("contentView is not null!");
        }
        if (errorView == null) {
            throw new NullPointerException("errorView is not null!");
        }
    }

    /**
     * 添加重写加载监听
     *
     * @param onClickListener
     */
    public void setOnErrorViewClickListener(View.OnClickListener onClickListener) {
        if (this.errorView != null) {
            this.errorView.setOnClickListener(onClickListener);
        }
    }

    private ILceAnimator getLceAnimator() {
        if (lceAnimator == null) {
            lceAnimator = DefaultLceAnimator.getInstance();
        }
        return lceAnimator;
    }

    /**
     * 绑定动画执行策略
     *
     * @param lceAnimator
     */
    public void setLceAnimator(ILceAnimator lceAnimator) {
        this.lceAnimator = lceAnimator;
    }

    /**
     * 注意：记得加判断，因为下拉刷新组件有正在加载头部视图，不需要显示加载过程了
     * @param pullToRefresh
     */
    @Override
    public void showLoading(boolean pullToRefresh) {
        if(!pullToRefresh){
            getLceAnimator().showLoading(loadingView, contentView, errorView);
        }
    }

    @Override
    public void showContent() {
        getLceAnimator().showContent(loadingView, contentView, errorView);
    }

    @Override
    public void showError() {
        getLceAnimator().showErrorView(loadingView, contentView, errorView);
    }

    @Override
    public void bindData(M data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
