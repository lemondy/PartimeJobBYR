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

    public static List<Post> getPartimePage(String url) throws IOException{
        List<Post> allPosts = new ArrayList<Post>();
        //load a Document form a URL
//        Connection conn = Jsoup.connect(url);
//
//        //pretend to be a browser
//        conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0");
//        Document doc = conn.get();
//
//        //get all data under tbody tag
//        Elements elements = doc.select("tbody tr");
//
//        for(Element e:elements){
//            Post p = new Post();
//            p.setPostTitle(e.select("tr.title_9 bg-odd").text());
//            p.setAuthorName((e.select("tr.title_12 bg-odd").text()));
//            p.setPostTime(e.select("tr.title_10 bg-odd").text());
//            allPosts.add(p);
//        }
        Connection conn = Jsoup.connect(url);
        // 修改http包中的header,伪装成浏览器进行抓取
        conn.header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/    20100101 Firefox/32.0");
        Document doc = conn.get();

        // 获取tbody元素下的所有tr元素
        Elements elements = doc.select("tbody tr");
        for(Element element : elements) {
            String companyName = element.getElementsByTag("company").text();
            String time = element.select("td.text-center").first().text();
            String address = element.getElementsByClass("preach-tbody-addre").text();

            Post p = new Post();
            p.setPostTitle(companyName);
            p.setAuthorName(address);
            p.setPostTime(time);
            allPosts.add(p);

//            System.out.println("公司："+companyName);
//            System.out.println("宣讲时间："+time);
//            System.out.println("宣讲学校：华中科技大学");
//            System.out.println("具体地点："+address);
//            System.out.println("---------------------------------");
        }
        return allPosts;
    }
}
