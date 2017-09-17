package com.geek.csdngeek.mvp;

/**
 * @Author:曾明
 * @Time:2017/9/16 15:52
 * @Description:
 */
public class BasePresenter {
    private BPreView bPresView;

    public BasePresenter(BPreView presView){
        bPresView = presView;
    }

    public boolean isAlive(){
        if(bPresView == null){
            return false;
        }
        return bPresView.isAlive();
    }
}
