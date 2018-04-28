package com.geek.csdngeek.ui.fragment;

import com.geek.csdngeek.enties.Geek;
import com.morse.mvplibrary.mvp.BaseContract;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public interface BlogView extends BaseContract.IView {
    void onSuccess(List<Geek> geeks);
}
