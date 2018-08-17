package com.geek.csdngeek.model;

import android.arch.lifecycle.MutableLiveData;

import com.geek.csdngeek.enties.Blog;

public class MainModel extends BaseViewModel<Blog> {

    public MutableLiveData<Blog> getBlog() {
        return mModel;
    }

}
