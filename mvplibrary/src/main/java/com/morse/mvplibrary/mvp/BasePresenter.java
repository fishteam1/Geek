package com.morse.mvplibrary.mvp;

import com.morse.mvplibrary.mvp.BaseContract.IView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by admin on 2018/4/27.
 */

public class BasePresenter<V extends IView> implements BaseContract.IPresenter<V> {

    private WeakReference<V> mView;
    private V proxyView;

    @Override
    public void attachView(V view) {
        mView = new WeakReference<V>(view);
        proxyView = (V) Proxy.newProxyInstance(
                view.getClass().getClassLoader(),
                view.getClass().getInterfaces(),
                new MVPInvocationHandler(mView.get()));
        Proxy.getProxyClass(view.getClass().getClassLoader(), view.getClass().getInterfaces());
    }

    @Override
    public void dettachView() {
        if (null != mView) {
            mView.clear();
            mView = null;
        }
    }

    public V getView() {
        return proxyView;
    }

    private boolean isAttach() {
        return null != mView && null != mView.get();
    }

    private class MVPInvocationHandler implements InvocationHandler {

        private IView mvpView;

        public MVPInvocationHandler(IView view) {
            mvpView = view;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (isAttach()) {
                return method.invoke(mvpView, args);
            }
            return null;
        }
    }
}
