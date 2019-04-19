package com.crawlf;

/**
 * Jsoup爬虫练习、
 * 爬取https://www.liaoxuefeng.com/category/0013738748415562fee26e070fa4664ad926c8e30146c67000的文字
 */

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo1 {
    public static void main(String[] args) throws Exception {
        //1 指定页面链接
        String url = "https://www.liaoxuefeng.com/category/0013738748415562fee26e070fa4664ad926c8e30146c67000";
        //2 建立与目标页面的连接
        Connection connection = Jsoup.connect(url);
        //3 解析目标页面
        //4 获取页面中的所有uk-article uk-clearfix的元素
        Document document = connection.get();
        Elements elements = document.getElementsByClass("uk-article uk-clearfix");
        System.out.println(elements.size());
        for (Element element:elements) {
            //5 取出div中的子元素
            Element link = element.child(0).child(0);
            //6 得到a标记中的内容
            String titletring = link.text();
            System.out.println(titletring);
        }

    }
}
