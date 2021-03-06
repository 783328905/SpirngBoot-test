package com.ctillnow.processor;

import com.ctillnow.bean.CsdnBlog;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class CsdnBlogProcessor implements PageProcessor {

    private static String username = "yixiao1874";// 设置csdn用户名
    private static int size = 0;// 共抓取到的文章数量

    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36");

    @Override
    public void process(Page page) {
        if (!page.getUrl().regex("http://blog.csdn.net/" + username + "/article/details/\\d+").match()) {
            //获取当前页码
            String number = page.getHtml().xpath("//li[@class='page-item active']//a[@class='page-link']/text()").toString();
            //匹配当前页码+1的页码也就是下一页，加入爬取列表中
            String targetUrls = page.getHtml().links()
                    .regex("http://blog.csdn.net/" + username + "/article/list/" + (Integer.parseInt(number) + 1)).get();
            page.addTargetRequest(targetUrls);

            List<String> detailUrls = page.getHtml().xpath("//li[@class='blog-unit']//a/@href").all();
            for (String list : detailUrls) {
                System.out.println(list);
            }
            page.addTargetRequests(detailUrls);
        } else {
            size++;// 文章数量加1
            CsdnBlog csdnBlog = new CsdnBlog();
            String path = page.getUrl().get();
            int id = Integer.parseInt(path.substring(path.lastIndexOf("/") + 1));
            String title = page.getHtml().xpath("//h1[@class='csdn_top']/text()").get();
            String date = page.getHtml().xpath("//div[@class='artical_tag']//span[@class='time']/text()").get();
            String copyright = page.getHtml().xpath("//div[@class='artical_tag']//span[@class='original']/text()").get();
            int view = Integer.parseInt(page.getHtml().xpath("//button[@class='btn-noborder']//span[@class='txt']/text()").get());
            csdnBlog.id(id).title(title).date(date).copyright(copyright).view(view);
            System.out.println(csdnBlog);
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request(HttpConstant.Method.GET);
        request.setPriority(0);
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CsdnBlogProcessor())
                .addUrl("http://blog.csdn.net/" + username)
                .addRequest(request)
                .thread(5).run();



        System.out.println("文章总数为" + size);
    }
}