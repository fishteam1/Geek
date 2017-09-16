package com.geek.csdngeek.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.geek.csdngeek.R;

import java.util.HashMap;

import butterknife.ButterKnife;

/**
 * 对话框基类
 *
 * @Author:曾明
 * @Time:2017/9/16 15:33
 * @Description:
 */
public abstract class BaseDialog extends Dialog {

    protected Context mContext;
    protected IConfirmListener mConfirmListener;
    protected ICancelListener mCancelListener;

    public void setConfirmListener(IConfirmListener confirmListener) {
        mConfirmListener = confirmListener;
    }

    public void setCancelListener(ICancelListener cancelListener) {
        mCancelListener = cancelListener;
    }

    protected abstract View initLayout();

    public BaseDialog(Context context) {
        this(context, R.style.common_dialog);
        mContext = context;
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        createDialog();
    }

    /**
     * 创建dialog
     */
    private void createDialog() {
        try {
            View view = initLayout();
            ButterKnife.bind(this,view);
            setContentView(view);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 外部方法，显示对话框
     */
    @Override
    public void show() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);

        // 设置居中
        getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.7f;
        getWindow().setAttributes(lp);
        getWindow().setLayout((size.x * 7 / 10), ViewGroup.LayoutParams.WRAP_CONTENT);

        super.show();
    }

    public interface IConfirmListener {
        void onConfirm(HashMap map);
    }

    public interface ICancelListener {
        void onCancel();
    }
}
