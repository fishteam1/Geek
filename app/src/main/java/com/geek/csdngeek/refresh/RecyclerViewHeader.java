package com.geek.csdngeek.refresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geek.csdngeek.R;

/**
 * 自定义RecyclerView头布局
 */
public class RecyclerViewHeader extends LinearLayout {

    /**
     * 动画执行时间
     */
    private final int ROTATE_ANIM_DURATION = 180;

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_REFRESHING = 2;

    /**
     * 当前状态
     */
    private int mState = STATE_NORMAL;
    /**
     * 头布局
     */
    private LinearLayout mContainer;
    /**
     * 箭头
     */
    private ImageView mArrowImageView;
    private TextView mHintTextView;
    private TextView mTitleTextView;
    private RelativeLayout mRealityContent;

    public RecyclerViewHeader(Context context) {
        super(context, null);
    }

    public RecyclerViewHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public RecyclerViewHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        //初始化，设置下拉刷新高度为0
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
        //获取下拉布局
        mContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.pullrefrefh_recyclerview_header, (ViewGroup) getParent(), true);
        //添加到容器
        addView(mContainer, lp);
        //设置布局显示的位置
        setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        mRealityContent = mContainer.findViewById(R.id.pullRefresh_reality_content);
        mArrowImageView = mContainer.findViewById(R.id.pullRefresh_arrow);
        mHintTextView = mContainer.findViewById(R.id.pullRefresh_text);
        mTitleTextView = mContainer.findViewById(R.id.pullRefresh_title);

        //初始化动画
//        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f);
//        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
//        mRotateUpAnim.setFillAfter(true);
//        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f);
//        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
//        mRotateDownAnim.setFillAfter(true);
    }

    /**
     * 状态联动
     *
     * @param state
     */
    public void setState(int state) {
        if (mState == state) {//如果状态相同，不做处理
            return;
        }
        if (STATE_REFRESHING == state) {
            // TODO: 2018/8/17 正在加载显示圆圈进度
//            mArrowImageView.clearAnimation();
//            mArrowImageView.setVisibility(View.INVISIBLE);
//            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            // TODO: 2018/8/17 显示箭头图片
//            mArrowImageView.setVisibility(View.VISIBLE);
//            mProgressBar.setVisibility(View.INVISIBLE);
        }

        switch (state) {
            case STATE_NORMAL://正常状态
                if (STATE_READY == mState) {
//                    mArrowImageView.startAnimation(mRotateDownAnim);
                }
                if (STATE_REFRESHING == mState) {
//                    mArrowImageView.clearAnimation();
                }
                mHintTextView.setText("下拉刷新");
                break;
            case STATE_READY://准备刷新
                if (STATE_READY != mState) {
//                    mArrowImageView.clearAnimation();
//                    mArrowImageView.startAnimation(mRotateUpAnim);
                    mHintTextView.setText("松开刷新数据");
                }
                break;
            case STATE_REFRESHING://刷新状态
                mHintTextView.setText("正在加载...");
                break;
            default:
                break;
        }

        mState = state;
    }

    /**
     * 设置显示的图片
     *
     * @param imagePath
     */
    public void setPullImage(String imagePath) {
//        Drawable fromPath=Drawable.createFromPath(imagePath);
//        mArrowImageView.setBackground(fromPath);
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        mArrowImageView.setImageBitmap(bitmap);
    }

    /**
     * 设置显示的文字
     *
     * @param text
     */
    public void setPullContent(String text) {
        mTitleTextView.setText(text);
    }

    /**
     * 获取实际高度
     *
     * @return
     */
    public int getRealityHeight() {
        return mRealityContent.getHeight();
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
        LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
        lp.height = height;
        mContainer.setLayoutParams(lp);
    }

    /**
     * 获取隐藏的高度
     *
     * @return
     */
    public int getVisibleHeight() {
        return mContainer.getLayoutParams().height;
    }
}
