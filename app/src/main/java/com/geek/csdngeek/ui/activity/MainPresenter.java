package com.geek.csdngeek.ui.activity;

import android.os.AsyncTask;
import android.util.Log;

import com.geek.csdngeek.enties.Title;
import com.geek.csdngeek.utils.Constanct;
import com.geek.csdngeek.utils.JsoupUtils;
import com.morse.mvplibrary.mvp.BasePresenter;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */

public class MainPresenter extends BasePresenter<MainView> {

    public void getTitle() {
        new TestJsoup().execute();
    }

    class TestJsoup extends AsyncTask<String, Integer, List<Title>> {

        @Override
        protected void onPreExecute() {
            Log.d(Constanct.TAG, "开始解析网络数据");
        }

        @Override
        protected void onPostExecute(List<Title> geekTitles) {
            super.onPostExecute(geekTitles);
            getView().onSuccess(geekTitles);
            Log.d(Constanct.TAG, "解析数据成功");
        }

        @Override
        protected List<Title> doInBackground(String... strings) {
            return JsoupUtils.getTitle("http://geek.csdn.net/");
        }
    }

}
