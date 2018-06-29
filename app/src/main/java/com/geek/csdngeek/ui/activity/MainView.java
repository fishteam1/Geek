package com.geek.csdngeek.ui.activity;

import com.morse.mvplibrary.mvp.BaseContract;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public interface MainView extends BaseContract.IView {

    void onSuccess(List<Title> titles);

}
