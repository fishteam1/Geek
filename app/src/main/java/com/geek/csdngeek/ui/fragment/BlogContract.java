package com.geek.csdngeek.ui.fragment;

import com.geek.csdngeek.enties.Blog;
import com.morse.mvplibrary.mvp.BaseContract;

import java.util.List;

public class BlogContract implements BaseContract {

    public interface BlogView extends IView {
        void onSuccess(List<Blog> blogs);
    }

    public interface IBlogModel extends IModel {
        List<Blog> getBlogs(String category, long shownOffset);
    }

}
