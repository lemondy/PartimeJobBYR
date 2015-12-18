package cn.edu.bit.lemondy.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bit.lemondy.beans.Post;

/**
 * Created by lemon on 12-15.
 * @description: 封装Jsoup提供的常用接口，用来从网上爬取数据
 */
public class JsoupUtils {

    public static List<Post> getPartimePage(String url,String prefixUrl) throws IOException{
        List<Post> allPosts = new ArrayList<Post>();
       //load a Document form a URL

        Connection conn = Jsoup.connect(url);
        // 修改http包中的header,伪装成浏览器进行抓取
        //set header
        conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0")
                .header("Host", "bbs.byr.cn")
                .header("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("X-Requested-With", "XMLHttpRequest")      //this is important, or the page will not get the parttime job information
                .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");

        Document doc = conn.get();
        //get the table data
        Elements elements = doc.select("tbody tr");
        System.out.println(elements.size());
        for(Element e:elements)
        {
            Post p = new Post();
            System.out.println("link:"+e.select("a[href]").first().attr("href"));
            //
            p.setPostUrl(prefixUrl+e.select("a[href]").first().attr("href"));
            System.out.println("title:"+e.select("td.title_9").first().text());
            p.setPostTitle(e.select("td.title_9").first().text());
            System.out.println("time:"+e.select("td.title_10").first().text());
            p.setPostTime(e.select("td.title_10").first().text().replaceAll("/?",""));
            p.setAuthorName(e.select("td.title_12").first().text());
            allPosts.add(p);
        }

        return allPosts;
    }

    public static List<Post> getWebpageDetail(String url) throws IOException{
        List<Post> allPosts = new ArrayList<Post>();
        //load a Document form a URL

        Connection conn = Jsoup.connect(url);
        // 修改http包中的header,伪装成浏览器进行抓取
        //set header
        conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0")
                .header("Host", "bbs.byr.cn")
                .header("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("X-Requested-With", "XMLHttpRequest")      //this is important, or the page will not get the parttime job information
                .header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");

        Document doc = conn.get();
        //replace <br> tag in html page
        String html = doc.html().replace("<br>", "$").replace("&nbsp;", "#");
        //System.out.println("html"+html);
        doc = Jsoup.parse(html);
        //get the table data
        Elements elements = doc.select("tbody tr");
        System.out.println(elements.size());
        for(Element e:elements)
        {
            //System.out.println(e.select("td.a-content").select("div.a-content-wrap").text().replace("$", "\n").replace("#", " "));
            Post p = new Post();
            p.setPostContent(e.select("td.a-content").select("div.a-content-wrap").text().replace("$", "\n").replace("#", " "));

//			System.out.println("link:"+e.select("a[href]").first().attr("href"));
//			System.out.println("title:"+e.select("td.title_9").first().text());
//			System.out.println("time:"+e.select("td.title_10").first().text());
            allPosts.add(p);
        }
        return allPosts;
    }
}
