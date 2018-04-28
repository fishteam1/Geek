package com.morse.mvplibrary.ui.activity;

import android.view.View;

import com.morse.mvplibrary.mvp.BaseContract;
import com.morse.mvplibrary.ui.lce.LceView;
import com.morse.mvplibrary.ui.lce.LceViewImp;
import com.morse.mvplibrary.ui.lce.animator.ILceAnimator;

/**
 * 集成lce的Activity
 * Created by admin on 2018/4/27.
 */
public abstract class LceActivity<V extends BaseContract.IView,P extends BaseContract.IPresenter<V>,M>
        extends MVPActivity<V,P> implements LceView<M> {
    // 初始化Lce UI布局（规定你的Lce布局文件的id）
    private LceViewImp<M> lceViewImpl;

    // 初始化Lce UI布局（规定你的Lce布局文件的id）

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        lceViewImpl = new LceViewImp<M>();
        initLceView(getWindow().getDecorView());
    }

    private void initLceView(View v) {
        lceViewImpl.initLceView(v);
        lceViewImpl.setOnErrorViewClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onErrorClick();
            }
        });
    }

    /**
     * 提供给子类配置自己想要的动画策略
     *
     * @param lceAnimator
     */
    public void setLceAnimator(ILceAnimator lceAnimator) {
        lceViewImpl.setLceAnimator(lceAnimator);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        lceViewImpl.showLoading(pullToRefresh);
    }

    @Override
    public void showContent() {
        lceViewImpl.showContent();
    }

    @Override
    public void showError() {
        lceViewImpl.showError();
    }

    public void onErrorClick() {
        loadData(false);
    }
}
