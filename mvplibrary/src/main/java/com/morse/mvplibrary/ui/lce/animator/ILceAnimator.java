package com.morse.mvplibrary.ui.lce.animator;

import android.view.View;

/**
 * Created by admin on 2018/4/27.
 */
public interface ILceAnimator {
    void showLoading(View loadingView, View contentView, View errorView);

    void showErrorView(View loadingView, View contentView, View errorView);

    void showContent(View loadingView, View contentView, View errorView);
}
