package com.geek.csdngeek.ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.geek.csdngeek.R;
import com.geek.csdngeek.ui.base.BaseActivity;

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

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void beforeView() {

    }

    @Override
    protected void afterView() {
        setTitle("极客头条详情页");

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
}
