package com.geek.csdngeek.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.geek.csdngeek.R;
import com.geek.csdngeek.model.MainModel;
import com.geek.csdngeek.ui.adapter.PageAdapter;
import com.geek.csdngeek.ui.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_geek)
    ViewPager vpGeek;

    private MainModel mModel;

    private PageAdapter mAdapter;

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void beforeView() {
    }

    @Override
    protected void afterView() {
        toolbar.setTitle("极客头条");
        setSupportActionBar(toolbar);

        mAdapter = new PageAdapter(getSupportFragmentManager());
        vpGeek.setAdapter(mAdapter);
        vpGeek.setCurrentItem(0);

        for (int i = 0; i < getResources().getStringArray(R.array.titles).length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(vpGeek);

        //tabLayout.setupWithViewPager()方法将会重置tabLayout，为了让TabLayout的标题显示出来，只能在该方法调用之后再去设置标题
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setText(getResources().getStringArray(R.array.titles)[i]);
        }

        mModel = ViewModelProviders.of(this).get(MainModel.class);

        mModel.getBlog();
    }
}
