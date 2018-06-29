package com.geek.csdngeek.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Blog;
import com.geek.csdngeek.ui.activity.GeekDetailActivity;
import com.geek.csdngeek.ui.adapter.BlogAdapter;
import com.geek.csdngeek.ui.base.BaseAbstractAdapter;
import com.geek.csdngeek.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：morse on 2017/9/17 21:50
 * 邮箱：zm902485jgsurjgc@163.com
 */
public class BlogFragment extends BaseFragment<BlogContract.BlogView, BlogPresenter> implements BlogContract.BlogView,
        BaseAbstractAdapter.IItemClickListener {

    @BindView(R.id.rv_blog)
    RecyclerView rvBlog;

    private BlogAdapter mAdapter;
    private String mBlogType = "home";

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
                return "home";
            case 1:
                return "watchers";
            case 2:
                return "newarticles";
            case 3:
                return "news";
            case 4:
                return "ai";
            case 5:
                return "cloud";
            case 6:
                return "blockchain";
            case 7:
                return "db";
            case 8:
                return "career";
            case 9:
                return "game";
            case 10:
                return "engineering";
            case 11:
                return "web";
            case 12:
                return "mobile";
            case 13:
                return "iot";
            case 14:
                return "ops";
            case 15:
                return "fund";
            case 16:
                return "lang";
            case 17:
                return "arch";
            case 18:
                return "avi";
            case 19:
                return "sec";
            case 20:
                return "other";
        }
        return "home";
    }

    @Override
    protected void afterView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvBlog.setLayoutManager(manager);
        rvBlog.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());
//        rvBlog.addItemDecoration(new SpaceItemDecoration(30));
        getBlogs();
    }

    @Override
    public BlogPresenter createPresenter() {
        return new BlogPresenter();
    }

    /**
     * 获取博客列表
     */
    private void getBlogs() {
        getPresenter().getBlogs(mBlogType);
    }

    @Override
    public void onItemClick(int position) {
        Blog blog = mAdapter.getItem(position);
        if (null != blog) {
            Intent intent = new Intent(getContext(), GeekDetailActivity.class);
            intent.putExtra("blog", blog);
            startActivity(intent);
        }
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<Blog> blogs) {
        if (null == blogs || blogs.isEmpty()) {
            return;
        }
        if (null == mAdapter) {
            mAdapter = new BlogAdapter(mContext);
            mAdapter.setItemClickListener(BlogFragment.this);
            rvBlog.setAdapter(mAdapter);
            mAdapter.setItems(blogs);
        } else {
            mAdapter.addItems(blogs);
        }
    }
}
