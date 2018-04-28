package com.morse.mvplibrary.mvp;

/**
 * Created by admin on 2018/4/27.
 */

public interface BaseContract {

    interface IView {
        void onFailed(String msg);
    }

    interface IPresenter<V extends IView> {

        void attachView(V view);

        void dettachView();

    }

    interface IModel {
    }

}
