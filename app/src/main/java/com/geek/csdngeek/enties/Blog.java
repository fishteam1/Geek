package com.geek.csdngeek.enties;

import java.io.Serializable;

/**
 * csdn 博客
 */
public class Blog implements Serializable{

    /**
     * strategy_id : query_search
     * views : 26314
     * score : 0.0076000075936973
     * comments : 12
     * channel : 移动开发
     * downs : 0
     * ups : 1
     * category : 移动开发
     * strategy : 最近搜过相似文章
     * cache_time : 1530237926
     * commits : 12
     * user_name : zhengyikuangge
     * url : https://blog.csdn.net/zhengyikuangge/article/details/51921549
     * nickname : 正义狂哥
     * category_id : mobile
     * desc : 1、比较：GPS准确度高但耗电多，网络定位耗电少但准确度低2、代码public class MainActivity extends Activity { //定位都要通过LocationManager这个类实现 private LocationManager locationManager; private String provider; @SuppressWarn
     * created_at : 07月15日
     * type : blog
     * isexpert : 0
     * id : 51921549
     * tag : android,GPS,网络定位
     * summary : 1、比较：GPS准确度高但耗电多，网络定位耗电少但准确度低2、代码public class MainActivity extends Activity { //定位都要通过LocationManager这个类实现 private LocationManager locationManager; private String provider; @SuppressWarn
     * quality_score : 0
     * views2 : 10351
     * title : Android获取当前位置（GPS和网络定位）
     * shown_offset : 1530236806693833
     * shown_time : 1530236806
     * user_url : https://blog.csdn.net/zhengyikuangge
     * avatar : https://avatar.csdn.net/7/2/4/1_zhengyikuangge.jpg
     */

    private String strategy_id;
    private int views;
    private String score;
    private int comments;
    private String channel;
    private String downs;
    private String ups;
    private String category;
    private String strategy;
    private String cache_time;
    private String commits;
    private String user_name;
    private String url;
    private String nickname;
    private String category_id;
    private String desc;
    private String created_at;
    private String type;
    private String isexpert;
    private String id;
    private String tag;
    private String summary;
    private String quality_score;
    private String views2;
    private String title;
    private long shown_offset;
    private String shown_time;
    private String user_url;
    private String avatar;

    public String getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(String strategy_id) {
        this.strategy_id = strategy_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDowns() {
        return downs;
    }

    public void setDowns(String downs) {
        this.downs = downs;
    }

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getCache_time() {
        return cache_time;
    }

    public void setCache_time(String cache_time) {
        this.cache_time = cache_time;
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsexpert() {
        return isexpert;
    }

    public void setIsexpert(String isexpert) {
        this.isexpert = isexpert;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getQuality_score() {
        return quality_score;
    }

    public void setQuality_score(String quality_score) {
        this.quality_score = quality_score;
    }

    public String getViews2() {
        return views2;
    }

    public void setViews2(String views2) {
        this.views2 = views2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getShown_offset() {
        return shown_offset;
    }

    public void setShown_offset(long shown_offset) {
        this.shown_offset = shown_offset;
    }

    public String getShown_time() {
        return shown_time;
    }

    public void setShown_time(String shown_time) {
        this.shown_time = shown_time;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
