package com.geek.csdngeek.refresh;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class PullRefreshRecyclerView extends RecyclerView {

    private float mLastY = -1;

    /**
     * 滚动需要的时候
     */
    public final static int SCROLL_DURATION = 200;

    /**
     * 提示消息显示的时间
     */
    public final static int MESSAGE_SHOW_DURATION = 2000;

    /**
     * 阻尼效果
     */
    private final static float OFFSET_RADIO = 1.5f;

    /**
     * 上拉的距离
     */
    private final static int PULL_LOAD_MORE_DELTA = 50;

    /**
     * 是否自动加载
     */
    private boolean mEnableAutoLoading = false;

    /**
     * 是否可以上拉
     */
    private boolean mEnablePullLoad = true;

    /**
     * 是否可以下拉
     */
    private boolean mEnablePullRefresh = true;

    /**
     * 是否正在加载
     */
    private boolean mPullLoading = false;

    /**
     * 是否正在刷新
     */
    private boolean mPullRefreshing = false;

    private int mScrollBack;

    /**
     * 下拉
     */
    private final static int SCROLLBACK_HEADER = 0;
    /**
     * 上拉
     */
    private final static int SCROLLBACK_FOOTER = 1;

    /**
     * 滚动器
     */
    private Scroller mScroller;

    /**
     * 头部
     */
    private RecyclerViewHeader mHeaderView;

    /**
     * 尾部
     */
    private RecyclerViewFooter mFooterView;

    /**
     * 消息提示类
     */
    private MessageRelativeLayout mParent;

    /**
     * adapte装饰类
     */
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;

    /**
     * 消息发送器
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mHeaderView.getVisibleHeight() == mParent.getHeaderMessageViewHeight()) {
                mScroller.startScroll(0, mHeaderView.getVisibleHeight(), 0, -mHeaderView.getVisibleHeight(), SCROLL_DURATION);
                postInvalidate();
            }

            mParent.hideMessage();
        }
    };

    public PullRefreshRecyclerView(@NonNull Context context) {
        super(context, null);
    }

    public PullRefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public PullRefreshRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        //初始化滚动器
        mScroller = new Scroller(context, new DecelerateInterpolator());
        //初始化头
        mHeaderView = new RecyclerViewHeader(context);
        mHeaderView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //初始化尾部
        mFooterView = new RecyclerViewFooter(context);
        mFooterView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    private Adapter mAdapter;

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        mAdapter = adapter;
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        super.setAdapter(mHeaderAndFooterWrapper);
        //添加头部，确保这是第一个
        mHeaderAndFooterWrapper.addHeaderView(mHeaderView);
        //添加尾部，确保这是第一个
        mHeaderAndFooterWrapper.addFooterView(mFooterView);
        //获取父容器
        if (getParent() instanceof MessageRelativeLayout) {
            mParent = (MessageRelativeLayout) getParent();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (mLastY == -1) {
            mLastY = e.getRawY();
        }
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录按下的时候的位置
                mLastY = e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float moveY = e.getRawY();
                //手指滑动的差值
                float distanceY = moveY - mLastY;
                mLastY = moveY;
                //第一个目标完全显示出来 头部高度大于0， daltay大于0 向下移动
                if (((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0
                        || ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 1
                        && (mHeaderView.getVisibleHeight() > 0 || distanceY > 0)) {
                    //更新头部高度
                    updateHeaderHeight(distanceY / OFFSET_RADIO);
                } else if (isSlideToBottom() && (mFooterView.getBottomMargin() > 0 || distanceY < 0)) {
                    //已到达底部，该bain状态或者自动加载
                    updateFooterHeight(-distanceY / OFFSET_RADIO);
                } else if (distanceY > 0) {
                    updateFooterHeight(-distanceY / OFFSET_RADIO);
                }
                break;
            default:
                mLastY = -1;//重置位置
                if (((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0
                        || ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 1) {
                    //松手时，高度大于一定值就刷新
                    if (mEnablePullRefresh && mHeaderView.getVisibleHeight() > mHeaderView.getRealityHeight()) {
                        mPullRefreshing = true;
                        mHeaderView.setState(RecyclerViewHeader.STATE_REFRESHING);
                        if (null != mOnRefreshListener) {
                            mOnRefreshListener.onRefresh();
                        }
                    }
                    resetHeaderHeight();
                } else if (isSlideToBottom()) {
                    if (mEnablePullLoad && mFooterView.getBottomMargin() > PULL_LOAD_MORE_DELTA
                            && !mPullLoading) {
                        mPullLoading = true;
                        mFooterView.setState(RecyclerViewFooter.STATE_LOADING);
                        if (null != mOnRefreshListener) {
                            mOnRefreshListener.onLoadMore();
                        }
                    }
                    resetFooterHeight();
                } else {
                    resetHeaderHeight();
                }
                break;
        }
        return super.onTouchEvent(e);
    }

    /**
     * 更新尾部高度
     * @param distance
     */
    private void updateFooterHeight(float distance) {
        int height = mFooterView.getBottomMargin() + (int) distance;
        if (mEnablePullLoad && !mPullLoading) {
            if (height > PULL_LOAD_MORE_DELTA) {
                //改变状态
                mFooterView.setState(RecyclerViewFooter.STATE_READY);
            } else {
                mFooterView.setState(RecyclerViewFooter.STATE_NORMAL);
            }
        }
        mFooterView.setBottomMargin(height);
    }

    /**
     * 更新头部刷新
     * @param distance
     */
    private void updateHeaderHeight(float distance) {
        //设置头部高度，原先的高度加上
        mHeaderView.setVisibleHeight((int) distance + mHeaderView.getVisibleHeight());
        //未处于刷新状态，更新箭头
        if (mEnablePullRefresh && !mPullRefreshing) {
            //下拉高度达到可以刷新位置
            if (mHeaderView.getVisibleHeight() > mHeaderView.getRealityHeight()) {
                mHeaderView.setState(RecyclerViewHeader.STATE_READY);
            } else {
                mHeaderView.setState(RecyclerViewHeader.STATE_NORMAL);
            }
        }
        //移动到顶部
        smoothScrollBy(0, 0);
    }

    /**
     * 重置头部高度
     */
    private void resetHeaderHeight() {
        int height = mHeaderView.getVisibleHeight();
        if (height == 0) {//如果等于0，不可见，直接返回
            return;
        }

        if (mPullRefreshing && height <= mHeaderView.getRealityHeight()) {
            return;
        }

        int finalHeight = 0;
        if (mPullRefreshing && height > mHeaderView.getRealityHeight()) {
            finalHeight = mHeaderView.getRealityHeight();
        }
        if (null != mParent) {
            if (mHeaderView.getVisibleHeight() == mParent.getHeaderMessageViewHeight()) {
                finalHeight = mParent.getHeaderMessageViewHeight();
            }
        }

        mScrollBack = SCROLLBACK_HEADER;//设置标识
        mScroller.startScroll(0, height, finalHeight - height, SCROLL_DURATION);
        //触发计算滚动
        invalidate();
    }

    /**
     * 重置尾部高度
     */
    private void resetFooterHeight() {
        int bottomMargin = mFooterView.getBottomMargin();
        if (bottomMargin > 0) {
            mScrollBack = SCROLLBACK_FOOTER;//设置标识
            mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, SCROLL_DURATION);
            invalidate();
        }
    }

    /**
     * 停止刷新
     */
    public void stopRefresh() {
        mScrollBack = SCROLLBACK_HEADER;//设置标识
        int obligateHeight = null != mParent ? mParent.getHeaderMessageViewHeight() : 0;
        int height = mHeaderView.getVisibleHeight();
        if (mPullRefreshing) {
            //重置
            mPullRefreshing = false;
            //显示更新多少条消息
            if (null != mParent) {
                mParent.showMessage();
            }
            mScroller.startScroll(0, height, obligateHeight - height, SCROLL_DURATION);
            //触发计算滚动
            invalidate();
            //触发执行复位动作
            if (null != mParent) {
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(1, MESSAGE_SHOW_DURATION);
            }
        }
    }

    /**
     * 停止加载更多
     */
    public void stopLoadMore() {
        if (mPullLoading) {
            mPullLoading = false;
            mFooterView.setState(RecyclerViewFooter.STATE_NORMAL);
        }
    }

    @Override
    public void computeScroll() {

        if (mScroller.computeScrollOffset()) {
            if (mScrollBack == SCROLLBACK_HEADER) {
                mHeaderView.setVisibleHeight(mScroller.getCurrY());
            } else {
                mFooterView.setBottomMargin(mScroller.getCurrY());
            }
            postInvalidate();
        }

        super.computeScroll();
    }

    private OnRefreshListener mOnRefreshListener;

    public void setOnRefreshListener(OnRefreshListener refreshListener) {
        mOnRefreshListener = refreshListener;
    }

    /**
     * 刷新接口
     */
    public interface OnRefreshListener {
        void onRefresh();

        void onLoadMore();
    }

    /**
     * 判断是否到底
     * @return
     */
    private boolean isSlideToBottom() {
        return computeVerticalScrollExtent() + computeVerticalScrollOffset() >= computeVerticalScrollRange();
    }
}
