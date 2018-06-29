package com.geek.csdngeek.network;

import com.geek.csdngeek.utils.Constanct;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author:morse
 * @Time:2017/9/16 16:11
 * @Description:
 */
public abstract class RetrofitUtils {

    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    protected static Retrofit getRetrofit() {

        if (null == mRetrofit) {

            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttpUtils.getOkHttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constanct.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();

        }

        return mRetrofit;
    }

}
