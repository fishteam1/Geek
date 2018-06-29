package com.geek.csdngeek.ui.fragment;

import com.geek.csdngeek.enties.Blog;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public class BlogModel implements BlogContract.IBlogModel{
    
    @Override
    public List<Blog> getBlogs(String category, long shownOffset) {
        return null;
    }
}
