package com.geek.csdngeek.ui.activity;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.geek.csdngeek.R;
import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.enties.GeekTitle;
import com.geek.csdngeek.ui.base.BaseActivity;
import com.geek.csdngeek.utils.Constanct;
import com.geek.csdngeek.utils.JsoupUtils;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void beforeView() {

    }

    @Override
    protected void afterView() {
        findViewById(R.id.btn_get_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TestJsoup().execute("http://geek.csdn.net/hot");
            }
        });
    }

    class TestJsoup extends AsyncTask<String, Integer, List<Geek>> {

        @Override
        protected void onPreExecute() {
            Log.d(Constanct.TAG, "开始解析网络数据");
        }

        @Override
        protected void onPostExecute(List<Geek> geekTitles) {
            super.onPostExecute(geekTitles);
            Log.d(Constanct.TAG, "解析数据成功");
        }

        @Override
        protected List<Geek> doInBackground(String... strings) {
            return JsoupUtils.getSource(strings[0]);
        }
    }

}
