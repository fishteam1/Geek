package com.geek.csdngeek.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器基类
 *
 * @Author:曾明
 * @Time:2017/9/16 15:05
 * @Description:
 */
public abstract class BaseAbstractAdapter<T> extends RecyclerView.Adapter<BaseHolder> {

    protected List<T> mItems;
    protected Context mContext;
    protected LayoutInflater mInflate;
    protected IItemClickListener mItemClickListener;
    protected IItemLongClickListener mItemLongClickListener;

    /**
     * 设置item单击事件
     *
     * @param itemClickListener
     */
    public void setItemClickListener(IItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    /**
     * 设置item长按事件
     *
     * @param itemLongClickListener
     */
    public void setItemLongClickListener(IItemLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;
    }

    protected abstract BaseHolder bindView();

    public BaseAbstractAdapter(Context context) {
        mContext = context;
        mInflate = LayoutInflater.from(context);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return bindView();
    }

    @Override
    public int getItemCount() {
        return null == mItems ? 0 : mItems.size();
    }

    /**
     * 设置适配数据
     *
     * @param items
     */
    public void setItems(List<T> items) {
        if (null != mItems) {
            mItems.clear();
        }
        addItems(items);
    }

    /**
     * 添加适配数据
     *
     * @param item
     */
    public void addItem(T item) {
        if (null == mItems) {
            mItems = new ArrayList<>();
        }
        if (null == item) {
            return;
        }
        mItems.add(item);
    }

    /**
     * 添加适配数据
     *
     * @param items
     */
    public void addItems(List<T> items) {
        if (null == mItems) {
            mItems = new ArrayList<>();
        }
        if (null == items || items.isEmpty()) {
            return;
        }
        mItems.addAll(items);
    }

    /**
     * 删除适配数据
     *
     * @param item
     */
    public void remove(T item) {
        if (null == item) {
            return;
        }
        if (null == mItems || mItems.isEmpty() || !mItems.contains(item)) {
            return;
        }
        mItems.remove(item);
    }

    /**
     * 删除适配数据
     *
     * @param position
     */
    public void remove(int position) {
        if (null == mItems || mItems.isEmpty() || getItemCount() <= position) {
            return;
        }
        mItems.remove(position);
    }

    public interface IItemClickListener {
        /**
         * item单击事件处理
         *
         * @param position
         */
        void onItemClick(int position);
    }

    public interface IItemLongClickListener {
        /**
         * item长按事件处理
         *
         * @param position
         */
        void onItemLongClick(int position);
    }
}
