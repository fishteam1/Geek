package com.geek.csdngeek.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.ui.base.BaseAbstractAdapter;
import com.geek.csdngeek.ui.base.BaseHolder;

import butterknife.BindView;

/**
 * 作者：morse on 2017/9/17 21:13
 * 邮箱：zm902485jgsurjgc@163.com
 */

public class BlogAdapter extends BaseAbstractAdapter<Geek> implements View.OnClickListener {

    public BlogAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseHolder bindView() {
        return new BlogHolder(mInflate.inflate(R.layout.include_blog_item, null));
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        BlogHolder blogHolder = (BlogHolder) holder;
        Geek item = mItems.get(position);
        blogHolder.itemView.setTag(position);
        blogHolder.itemView.setOnClickListener(this);
        blogHolder.tvTitle.setText(item.getTitle());
        blogHolder.tvTime.setText(item.getTime());
        blogHolder.tvForum.setText(item.getForum());
        blogHolder.tvCount.setText(item.getCount());
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (null != mItemClickListener) {
            mItemClickListener.onItemClick(position);
        }
    }

    class BlogHolder extends BaseHolder {

        @BindView(R.id.tv_blog_title)
        TextView tvTitle;
        @BindView(R.id.tv_blog_public_time)
        TextView tvTime;
        @BindView(R.id.tv_blog_forum)
        TextView tvForum;
        @BindView(R.id.tv_blog_read_count)
        TextView tvCount;

        public BlogHolder(View itemView) {
            super(itemView);
        }
    }
}
