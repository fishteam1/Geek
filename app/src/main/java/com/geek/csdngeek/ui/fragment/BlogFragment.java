package com.geek.csdngeek.ui.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.ui.activity.GeekDetailActivity;
import com.geek.csdngeek.ui.adapter.BlogAdapter;
import com.geek.csdngeek.ui.base.BaseAbstractAdapter;
import com.geek.csdngeek.ui.base.BaseFragment;
import com.geek.csdngeek.utils.Constanct;
import com.geek.csdngeek.utils.JsoupUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：morse on 2017/9/17 21:50
 * 邮箱：zm902485jgsurjgc@163.com
 */
public class BlogFragment extends BaseFragment<BlogView, BlogPresenter> implements BlogView,
        BaseAbstractAdapter.IItemClickListener {

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
        Geek geek = mAdapter.getItem(position);
        if (null != geek) {
            Intent intent = new Intent(getContext(), GeekDetailActivity.class);
            intent.putExtra("geek", geek);
            startActivity(intent);
        }
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<Geek> geeks) {
        if (null == geeks || geeks.isEmpty()) {
            return;
        }
        if (null == mAdapter) {
            mAdapter = new BlogAdapter(mContext);
            mAdapter.setItemClickListener(BlogFragment.this);
            rvBlog.setAdapter(mAdapter);
            mAdapter.setItems(geeks);
        } else {
            mAdapter.addItems(geeks);
        }
    }
}
