package com.morse.mvplibrary.ui.activity;

import android.util.Log;

import com.morse.mvplibrary.mvp.BaseContract;
import com.morse.mvplibrary.ui.MVPCallBack;
import com.morse.mvplibrary.ui.MVPCallBackImp;

import java.lang.ref.WeakReference;

/**
 * Created by admin on 2018/4/27.
 */
public class ActivityDelegateImp<V extends BaseContract.IView, P extends BaseContract.IPresenter<V>> implements ActivityDelegate {

    private MVPCallBackImp<V, P> mvpCallBack;

    public ActivityDelegateImp(MVPCallBack<V, P> callBack) {
        if (null == callBack) {
            throw new NullPointerException("MVPCallBack is null");
        }
        mvpCallBack = new MVPCallBackImp<>(callBack);
    }

    @Override
    public void onCreate() {
        mvpCallBack.createPresenter();
        mvpCallBack.attach();
    }

    @Override
    public void onDestroy() {
        if (null == mvpCallBack) {
            Log.d("morse", "mvpCallBack is null");
        }
        mvpCallBack.dettach();
    }
}
