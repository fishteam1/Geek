package com.geek.csdngeek.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.csdngeek.R;
import com.geek.csdngeek.ui.adapter.BlogAdapter;
import com.geek.csdngeek.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者：morse on 2017/9/17 21:50
 * 邮箱：zm902485jgsurjgc@163.com
 */
public class BlogFragment extends BaseFragment {

    @BindView(R.id.rv_blog)
    RecyclerView rvBlog;

    private BlogAdapter mAdapter;
    private String mBlogType = "/hot";

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_blog, null);
    }

    @Override
    protected void beforeView() {
        super.beforeView();
        Bundle bundle = getArguments();
        int type = bundle.getInt("blog_type");
        mBlogType = getBlogType(type);
    }

    private String getBlogType(int type) {
        switch (type) {
            case 0:
                return "/hot";
            case 1:
                return "/new";
            case 2:
                return "/news";
            case 3:
                return "/cloud";
            case 4:
                return "/bigdata";
            case 5:
                return "/AI";
            case 6:
                return "/iot";
            case 7:
                return "/language";
            case 8:
                return "/database";
            case 9:
                return "/frontend";
            case 10:
                return "/mobile";
            case 11:
                return "/os";
            case 12:
                return "/game";
            case 13:
                return "/tools";
            case 14:
                return "/se";
            case 15:
                return "/career";
            case 16:
                return "/osproject";
        }
        return "/hot";
    }

    @Override
    protected void afterView() {
        mAdapter = new BlogAdapter(mContext);
        rvBlog.setAdapter(mAdapter);

        getBlogs(0);
    }

    /**
     * 获取博客列表
     *
     * @param page 请求的页面
     */
    private void getBlogs(int page) {

    }
}
