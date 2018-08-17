package com.geek.csdngeek.refresh;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.geek.csdngeek.R;

public class MessageRelativeLayout extends RelativeLayout {

    /**
     * 显示消息的控件
     */
    private LinearLayout mHeaderMessageView;
    private TextView mHeaderMessageText;

    private int mHeaderMessageViewHeight;

    /**
     * 滚动器
     */
    private Scroller mScroller;

    public MessageRelativeLayout(Context context) {
        super(context, null);
    }

    public MessageRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MessageRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context, new DecelerateInterpolator());
        //初始化显示消息的控件
        mHeaderMessageView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pullrefresh_header_message, (ViewGroup) getParent(), false);
        mHeaderMessageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mHeaderMessageText = mHeaderMessageView.findViewById(R.id.pullRefresh_message);
        //初始化头部的高度
        mHeaderMessageText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                mHeaderMessageViewHeight = mHeaderMessageText.getHeight();

                getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //确保添加在后面
        addView(mHeaderMessageView, 1);
    }

    public void showMessage() {
        mScroller.startScroll(0, getHeaderMessageViewHeight(), 0, 0, PullRefreshRecyclerView.SCROLL_DURATION);
        invalidate();
    }

    /**
     * 隐藏消息
     */
    public void hideMessage() {
        mScroller.startScroll(0, getVisibleHeight(), 0, -getVisibleHeight(), PullRefreshRecyclerView.SCROLL_DURATION);
        invalidate();
    }

    /**
     * 设置消息
     *
     * @param message
     */
    public void setMessage(String message) {
        mHeaderMessageText.setText(message);
    }

    /**
     * 获取消息总高度
     *
     * @return
     */
    public int getHeaderMessageViewHeight() {
        return mHeaderMessageViewHeight;
    }

    /**
     * 设置隐藏的高度
     *
     * @param height
     */
    public void setVisibleHeight(int height) {
        if (height < 0) {
            height = 0;
        }
        ViewGroup.LayoutParams lp = mHeaderMessageView.getLayoutParams();
        lp.height = height;
        mHeaderMessageView.setLayoutParams(lp);
    }

    /**
     * 获取隐藏的高度
     *
     * @return
     */
    public int getVisibleHeight() {
        return mHeaderMessageView.getLayoutParams().height;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            setVisibleHeight(mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }
}
