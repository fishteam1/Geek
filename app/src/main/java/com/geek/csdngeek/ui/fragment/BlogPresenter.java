package com.geek.csdngeek.ui.fragment;

import android.os.AsyncTask;
import android.util.Log;

import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.utils.Constanct;
import com.geek.csdngeek.utils.JsoupUtils;
import com.morse.mvplibrary.mvp.BasePresenter;

import java.util.List;

/**
 * Created by admin on 2018/4/28.
 */
public class BlogPresenter extends BasePresenter<BlogView> {

    public BlogPresenter() {

    }

    public void getBlogs(String blogType) {
        new TestJsoup().execute(Constanct.URL_BASE + blogType);
    }

    class TestJsoup extends AsyncTask<String, Integer, List<Geek>> {

        @Override
        protected void onPreExecute() {
            Log.d(Constanct.TAG, "开始解析网络数据");
        }

        @Override
        protected void onPostExecute(List<Geek> geeks) {
            super.onPostExecute(geeks);
            getView().onSuccess(geeks);
            Log.d(Constanct.TAG, "解析数据成功");
        }

        @Override
        protected List<Geek> doInBackground(String... strings) {
            return JsoupUtils.getSource(strings[0]);
        }
    }

}
