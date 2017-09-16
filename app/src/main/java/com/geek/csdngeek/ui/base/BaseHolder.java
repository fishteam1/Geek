package com.geek.csdngeek.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @Author:曾明
 * @Time:2017/9/16 15:10
 * @Description:
 */
public class BaseHolder extends RecyclerView.ViewHolder {
    public BaseHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
