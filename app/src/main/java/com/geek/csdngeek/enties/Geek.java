package com.geek.csdngeek.enties;

/**
 * @Author:曾明
 * @Time:2017/9/16 18:14
 * @Description:
 */
public class Geek {
    private String url;
    private String title;
    private String time;
    private String forum;
    private String count;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Geek{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", forum='" + forum + '\'' +
                ", count=" + count +
                '}';
    }
}
