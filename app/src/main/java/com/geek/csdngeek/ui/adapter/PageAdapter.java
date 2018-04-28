package com.geek.csdngeek.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.geek.csdngeek.ui.base.BaseFragment;
import com.geek.csdngeek.ui.fragment.BlogFragment;
import com.geek.csdngeek.utils.Constanct;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：morse on 2017/9/17 21:47
 * 邮箱：zm902485jgsurjgc@163.com
 */

public class PageAdapter extends FragmentPagerAdapter {

    private BaseFragment[] mFragment;//使用数组解决Can't change tag of fragment BlogFragment{c233b7e id=0x7f0800c3 android:switcher:2131230915:3}的问题

    public PageAdapter(FragmentManager fm) {
        super(fm);
        mFragment = new BaseFragment[Constanct.MAX_PAGE_SIZE];
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = null;
        if (position < getCount()) {
            fragment = mFragment[position];
        }
        if (null == fragment) {
            fragment = new BlogFragment();
            Bundle bundle = new Bundle();
            //fragment通过setArguments传递参数
            bundle.putInt("blog_type", position);
            fragment.setArguments(bundle);
            mFragment[position] = fragment;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragment.length;
    }
}
