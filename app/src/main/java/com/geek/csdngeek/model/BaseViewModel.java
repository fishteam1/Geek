package com.geek.csdngeek.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class BaseViewModel<T> extends ViewModel {

    protected MutableLiveData<T> mModel = new MutableLiveData<>();



}
