package com.morse.mvplibrary.ui.fragment;

import com.morse.mvplibrary.mvp.BaseContract;
import com.morse.mvplibrary.ui.MVPCallBack;
import com.morse.mvplibrary.ui.MVPCallBackImp;

import java.lang.ref.WeakReference;

/**
 * Created by admin on 2018/4/27.
 */

public class FragmentDelegateImp<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>> implements FragmentDelegate {

    private MVPCallBackImp<V, P> mvpCallBack;

    public FragmentDelegateImp(MVPCallBack<V, P> callBack) {
        if (null == callBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        mvpCallBack = new MVPCallBackImp<V, P>(callBack);
    }

    @Override
    public void onCreateView() {
        mvpCallBack.createPresenter();
        mvpCallBack.attach();
    }

    @Override
    public void onDestroy() {
        mvpCallBack.dettach();
    }
}
