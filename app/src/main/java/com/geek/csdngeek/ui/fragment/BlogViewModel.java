package com.geek.csdngeek.ui.fragment;

import com.geek.csdngeek.enties.Blog;
import com.geek.csdngeek.model.BaseViewModel;

import java.util.List;

public class BlogViewModel extends BaseViewModel<List<Blog>> {

    public List<Blog> getBlog() {
        return mModel.getValue();
    }

}
