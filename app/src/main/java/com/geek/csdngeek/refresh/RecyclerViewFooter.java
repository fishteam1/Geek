package com.geek.csdngeek.refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geek.csdngeek.R;

public class RecyclerViewFooter extends LinearLayout {

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_LOADING = 2;

    private Context context;
    private View contentView;
    private View progressBar;
    private TextView hintView;

    public RecyclerViewFooter(Context context) {
        super(context, null);
    }

    public RecyclerViewFooter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public RecyclerViewFooter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        LinearLayout moreView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pullrefrefh_recyclerview_footer, null);
        addView(moreView);
        moreView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        contentView = moreView.findViewById(R.id.pullrefrefh_footer_content);
        progressBar = moreView.findViewById(R.id.pullrefrefh_footer_ProgressBar);
        hintView = moreView.findViewById(R.id.pullrefrefh_footer_hint_TextView);
    }

    /**
     * 设置状态
     *
     * @param state
     */
    public void setState(int state) {
        hintView.setVisibility(INVISIBLE);
        progressBar.setVisibility(INVISIBLE);
        hintView.setVisibility(INVISIBLE);

        if (STATE_READY == state) {
            hintView.setVisibility(VISIBLE);
            hintView.setText("松开加载更多");
        } else if (STATE_LOADING == state) {
            progressBar.setVisibility(VISIBLE);
        } else {
            hintView.setVisibility(VISIBLE);
            hintView.setText("查看更多");
        }
    }

    /**
     * 设置距离下边的BottomMargin
     *
     * @param height
     */
    public void setBottomMargin(int height) {
        if (height < 0) {
            height = 0;
        }
        LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
        lp.bottomMargin = height;
        contentView.setLayoutParams(lp);
    }

    public int getBottomMargin() {
        LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
        return lp.bottomMargin;
    }

    /**
     * hide footer when disable pull load more
     */
    public void hide() {
        LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
        lp.height = 0;
        contentView.setLayoutParams(lp);
    }

    /**
     * show footer
     */
    public void show() {
        LayoutParams lp = (LayoutParams) contentView.getLayoutParams();
        lp.height = LayoutParams.WRAP_CONTENT;
        contentView.setLayoutParams(lp);
    }
}
