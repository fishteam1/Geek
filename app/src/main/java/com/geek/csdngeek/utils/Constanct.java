package com.geek.csdngeek.utils;

/**
 * 常量配置
 *
 * @Time:2017/9/16 16:08
 * @Description:
 */
public interface Constanct {
    String TAG = "Geek";
    String URL_BASE = "https://www.csdn.net/";
    String URL_HOME = "api/articles?type=more&category=home&shown_offset=1534474514294365";
    String URL_UPDATE = "api/articles?type=new&category=home";//home更新

//    <li class="active"><a href="/">推荐</a></li>
//                                        <li class=""><a href="/nav/newarticles">最新文章</a></li>
//                                        <li class=""><a href="/nav/watchers">关注</a></li>
//                                        <li class=""><a href="/nav/news">资讯</a></li>
//                                        <li class=""><a href="/nav/ai">人工智能</a></li>
//                                        <li class=""><a href="/nav/cloud">云计算/大数据</a></li>
//                                        <li class=""><a href="/nav/blockchain">区块链</a></li>
//                                        <li class=""><a href="/nav/db">数据库</a></li>
//                                        <li class=""><a href="/nav/career">程序人生</a></li>
//                                        <li class=""><a href="/nav/game">游戏开发</a></li>
//                                        <li class=""><a href="/nav/engineering">研发管理</a></li>
//                                        <li class=""><a href="/nav/web">前端</a></li>
//                                        <li class=""><a href="/nav/mobile">移动开发</a></li>
//                                        <li class=""><a href="/nav/iot">物联网</a></li>
//                                        <li class=""><a href="/nav/ops">运维</a></li>
//                                        <li class=""><a href="/nav/fund">计算机基础</a></li>
//                                        <li class=""><a href="/nav/lang">编程语言</a></li>
//                                        <li class=""><a href="/nav/arch">架构</a></li>
//                                        <li class=""><a href="/nav/avi">音视频开发</a></li>
//                                        <li class=""><a href="/nav/sec">安全</a></li>
//                                        <li class=""><a href="/nav/other">其他</a></li>

    int MAX_PAGE_SIZE = 21;

    /**
     * Crash日志保存路径
     */
    String PATH_CRASH = "";
}
