//package com.geek.csdngeek.utils;
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 网页爬虫数据解析
// * <p>教程：http://www.jianshu.com/p/a620a2664f58</p>
// * <p>通过ID获取控件：http://bbs.csdn.net/topics/390874704</p>
// *
// * @Time:2017/9/16 16:51
// * @Description:
// */
//public class JsoupUtils {
//
//    /**
//     * 获取数据实体
//     *
//     * @param url
//     */
//    public static List<Geek> getSource(String url) {
//        List<Geek> geeks = new ArrayList<>();
//        try {
//            Document doc = Jsoup.connect(url).get();
////            Elements contents = doc.select("div[id=geek_list]");
//            //获取id为geek_list的所有控件
//            Elements contents = doc.select("dl.geek_list");
//            for (int i = 0; i < contents.size(); i++) {
//                Geek geek = new Geek();
//                //获取修饰类为tracking-ad的dd控件
//                Elements dds = contents.get(i).select("dd.tracking-ad");
//                //获取span控件
//                Elements span = dds.select("span");
//                //获取span控件文本
//                String title = span.text();
//                geek.setTitle(title);
//                //获取span对应的链接
//                for (Element element : span) {
//                    Elements elements = element.getElementsByClass("title");
//                    if (elements.size() > 0) {
//                        geek.setUrl(elements.first().select("a").attr("href"));
//                        break;
//                    }
//                }
//                if (TextUtils.isEmpty(geek.getUrl())) {
//                    String uri = span.last().select("a").attr("href");
//                    geek.setUrl(uri);
//                }
//                //获取修饰类为list-inline的ul控件
//                Elements uls = dds.select("ul.list-inline");
//                //获取ul控件中的li控件
//                Elements lis = uls.select("li");
//                //获取第二个li文本
//                String time = lis.get(1).text();//时间
//                geek.setTime(time);
//                //获取第三个li的文本
//                String forum = lis.get(2).select("a").text();//所属论坛
//                geek.setForum(forum);
//                //获取第四个li中em控件的文本
//                String count = lis.get(3).select("em").text();//阅读数量
//                geek.setCount(count);
//                geeks.add(geek);
//            }
//            Log.d(Constanct.TAG, geeks.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return geeks;
//    }
//
//    /**
//     * 获取标题和对应的链接
//     *
//     * @param url
//     * @return
//     */
//    public static List<Title> getTitle(String url) {
//        List<Title> titles = new ArrayList<>();
//        try {
//            Document doc = Jsoup.connect(url).get();
//            //获取标题列表，找到类：nav_com
//            Elements divEle = doc.select("div.nav_com");
//            if (null == divEle || divEle.size() <= 0) {
//                return null;
//            }
//            //获取标题文本
//            List<String> tempTitles = divEle.eachText();
//            if (null == tempTitles || tempTitles.isEmpty()) {
//                return titles;
//            }
//            String[] title = tempTitles.get(0).split(" ");
//            //获取标题对应的连接，在列表ul里面，找到类：list-unstyled，对应列表中的属性“a”
//            List<String> urls = divEle.first().select("li").select("a").eachAttr("href");
//            if (null == urls || urls.isEmpty()) {
//                return titles;
//            }
//            for (int i = 0; i < urls.size(); i++) {
//                Title geek = new Title();
//                //获取标题
//                geek.setTitle(title[i]);
//                //获取标题对应的url链接
//                geek.setUrl(urls.get(i));
//                titles.add(geek);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return titles;
//    }
//
//}
