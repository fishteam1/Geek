package com.geek.csdngeek.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * activity基类
 *
 * @Author:曾明
 * @Time:2017/9/16 15:23
 * @Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 初始化窗口信息
     */
    protected void beforeLayout() {
    }

    /**
     * 初始化布局
     */
    protected abstract void initLayout();

    /**
     * 初始化view之前做一些处理
     */
    protected abstract void beforeView();

    /**
     * 初始化数据
     */
    protected abstract void afterView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeLayout();
        super.onCreate(savedInstanceState);
        try {
            initLayout();
            ButterKnife.bind(this);
            beforeView();
            afterView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
