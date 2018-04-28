package com.morse.mvplibrary.ui.lce;

/**
 * Created by admin on 2018/4/27.
 */

public interface LceView<M> {

    /**
     * 显示loading页面 pullToRefresh：true代表你用的是下拉刷新组件
     *
     * @param pullToRefresh
     */
    void showLoading(boolean pullToRefresh);

    /**
     * 显示ContentView
     */
    void showContent();

    /**
     * 显示异常界面
     */
    void showError();

    /**
     * 绑定数据
     *
     * @param data
     */
    void bindData(M data);

    /**
     * 加载数据
     *
     * @param pullToRefresh
     */
    void loadData(boolean pullToRefresh);

}
