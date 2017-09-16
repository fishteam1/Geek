package com.geek.csdngeek.utils;

import android.util.Log;

import com.geek.csdngeek.enties.Geek;
import com.geek.csdngeek.enties.GeekTitle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 网页爬虫数据解析
 * <p>教程：http://www.jianshu.com/p/a620a2664f58</p>
 *
 * @Author:曾明
 * @Time:2017/9/16 16:51
 * @Description:
 */
public class JsoupUtils {

    /**
     * 获取数据内容
     *
     * @param url
     */
    public static List<Geek> getSource(String url) {
        List<Geek> geeks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
//            Elements contents = doc.select("div[id=geek_list]");
            Elements contents = doc.select("dl.geek_list");
            for (int i = 0; i < contents.size(); i++) {
                Geek geek = new Geek();
                Elements dds = contents.get(i).select("dd.tracking-ad");
                Elements span = dds.select("span");
                String title = span.text();
                geek.setTitle(title);
                String uri = span.get(0).select("a").attr("href");
                geek.setUrl(uri);
                Elements uls = dds.select("ul.list-inline");
                Elements lis = uls.select("li");
                String time = lis.get(1).text();//时间
                geek.setTime(time);
                String forum = lis.get(2).select("a").text();//所属论坛
                geek.setForum(forum);
                String count = lis.get(3).select("em").text();//阅读数量
                geek.setCount(count);
                geeks.add(geek);
            }
            Log.d(Constanct.TAG, geeks.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return geeks;
    }

    /**
     * 获取标题和对应的链接
     *
     * @param url
     * @return
     */
    public static List<GeekTitle> getTitle(String url) {
        List<GeekTitle> titles = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            //获取标题列表，找到类：top_nav
            Elements divEle = doc.select("div.top_nav");
            //获取标题文本
            List<String> tempTitles = divEle.eachText();
            if (null == tempTitles || tempTitles.isEmpty()) {
                return titles;
            }
            String[] title = tempTitles.get(0).split(" ");
            List<String> titleList = Arrays.asList(title);
            //获取标题对应的连接，在列表ul里面，找到类：list-unstyled，对应列表中的属性“a”
            Elements urls = divEle.select("ul.list-unstyled").select("a");
            if (null == urls || urls.isEmpty()) {
                return titles;
            }
            for (int i = 0; i < titleList.size(); i++) {
                GeekTitle geek = new GeekTitle();
                //获取标题
                geek.setTitle(titleList.get(i));
                //获取标题对应的url链接
                geek.setUrl(urls.get(i).attr("href"));
                titles.add(geek);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

}
