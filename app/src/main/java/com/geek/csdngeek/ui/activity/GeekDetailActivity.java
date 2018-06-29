package com.geek.csdngeek.ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Blog;
import com.geek.csdngeek.ui.base.BaseActivity;
import com.geek.csdngeek.utils.GeekWebClient;

import butterknife.BindView;

/**
 * 作者：morse on 2017/9/17 14:09
 * 邮箱：zm902485jgsurjgc@163.com
 */
public class GeekDetailActivity extends BaseActivity {

    @BindView(R.id.iv_detail_backdrop)
    ImageView ivDetailBackdrop;
    @BindView(R.id.tb_detail_toolbar)
    Toolbar tbDetailToolbar;
    @BindView(R.id.ctl_detail_collapsing)
    CollapsingToolbarLayout ctlDetailCollapsing;
    @BindView(R.id.abl_detail_appbar)
    AppBarLayout ablDetailAppbar;
    @BindView(R.id.wv_detail)
    WebView wvDetail;
    @BindView(R.id.fab_detail)
    FloatingActionButton fabDetail;

    private Blog mBlog;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void beforeView() {
        mBlog = (Blog) getIntent().getSerializableExtra("blog");
    }

    @Override
    protected void afterView() {
        tbDetailToolbar.setTitle(mBlog.getTitle());
        setSupportActionBar(tbDetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//        ctlDetailCollapsing.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
//        ctlDetailCollapsing.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
//        ctlDetailCollapsing.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
        wvDetail.loadUrl(mBlog.getUrl());
        wvDetail.setWebViewClient(new GeekWebClient());

        fabDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(fabDetail, "点击了控件 FloatingActionButton", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode && null != wvDetail && wvDetail.canGoBack()) {
            wvDetail.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        wvDetail.removeAllViews();
        wvDetail.destroy();
        super.onDestroy();
    }
}
