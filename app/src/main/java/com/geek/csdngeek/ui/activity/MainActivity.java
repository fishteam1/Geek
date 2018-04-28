package com.geek.csdngeek.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Title;
import com.geek.csdngeek.ui.adapter.PageAdapter;
import com.geek.csdngeek.ui.base.BaseMVPActivity;
import com.geek.csdngeek.utils.Constanct;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<MainView, MainPresenter> implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_geek)
    ViewPager vpGeek;

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

        for (int i = 0; i < Constanct.MAX_PAGE_SIZE; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(vpGeek);
        getPresenter().getTitle();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick(R.id.fab)
    public void refresh(View view) {
        //更新数据
    }

    @Override
    public void onSuccess(List<Title> titles) {
        if (null != titles && !titles.isEmpty()) {
            for (int i = 0; i < titles.size(); i++) {
                tabLayout.getTabAt(i).setText(titles.get(i).getTitle());
            }
        }
    }
}
