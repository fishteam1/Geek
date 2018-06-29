package com.geek.csdngeek.ui.fragment;

import com.morse.mvplibrary.mvp.BasePresenter;

/**
 * Created by admin on 2018/4/28.
 */
public class BlogPresenter extends BasePresenter<BlogContract.BlogView> {

    private BlogModel mModel;

    public BlogPresenter() {
        mModel = new BlogModel();
    }

    public void getBlogs(String blogType) {
        mModel.getBlogs(blogType,1530236806693834L);
    }

}
