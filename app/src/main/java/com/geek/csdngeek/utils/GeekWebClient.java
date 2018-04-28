package com.geek.csdngeek.utils;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by admin on 2018/4/28.
 */

public class GeekWebClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!TextUtils.isEmpty(url) && (url.startsWith("http") || url.startsWith("https"))) {
            view.loadUrl(url);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

}
