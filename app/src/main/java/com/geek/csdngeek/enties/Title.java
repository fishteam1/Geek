package com.geek.csdngeek.enties;

/**
 * @Author:morse
 * @Time:2017/9/16 17:05
 * @Description:
 */
public class Title {
    private String title;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GeekTitle{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}