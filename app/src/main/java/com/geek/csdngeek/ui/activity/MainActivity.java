package com.geek.csdngeek.ui.activity;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.ui.adapter.PageAdapter;
import com.geek.csdngeek.ui.base.BaseActivity;
import com.geek.csdngeek.utils.Constanct;
import com.geek.csdngeek.utils.JsoupUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

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
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setupWithViewPager(vpGeek);
    }

    @OnClick(R.id.fab)
    public void refresh(View view) {
        //更新数据
    }

    class TestJsoup extends AsyncTask<String, Integer, List<Geek>> {

        @Override
        protected void onPreExecute() {
            Log.d(Constanct.TAG, "开始解析网络数据");
        }

        @Override
        protected void onPostExecute(List<Geek> geekTitles) {
            super.onPostExecute(geekTitles);
            Log.d(Constanct.TAG, "解析数据成功");
        }

        @Override
        protected List<Geek> doInBackground(String... strings) {
            return JsoupUtils.getSource(strings[0]);
        }
    }

}
