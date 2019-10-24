package com.ctillnow.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by caiping on 2019/10/24.
 */
public class CnblogsSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        if (!page.getUrl().regex("http://www.cnblogs.com/[a-z 0-9 -]+/p/[0-9]{7}.html").match()) {
            page.addTargetRequests(
                    page.getHtml().xpath("//*[@id=\"mainContent\"]/div/div/div[@class=\"postTitle\"]/a/@href").all());
            page.putField(page.getHtml().xpath("//*[@id=\"cb_post_title_url\"]/text()").toString(),
                    page.getHtml().xpath("//*[@id=\"cb_post_title_url\"]/@href").toString());
            page.putField("content",page.getHtml().xpath("//*[@id=\"topics\"]/div/div[2]").toString());
            //*[@id="topics"]/div/div[2]
            //*[@id="cnblogs_post_body"]/text()

            //*[@id="mainContent"]/div/div[6]/div[2]/@href
            //*[@id="mainContent"]/div/div[6]/div[2]/text()
        } else {
            page.putField(page.getHtml().xpath("//*[@id=\"TopFeedbackPostsBlock\"]/ul/li[1]/a/text()").toString(),
                    page.getHtml().xpath("//*[@id=\"TopFeedbackPostsBlock\"]/ul/li[1]/a").toString());
            //////*[@id="TopFeedbackPostsBlock"]/ul/li[1]/a
        }
    }

    public static void main(String[] args) {
        Spider.create(new CnblogsSpider()).addUrl("http://www.cnblogs.com/justcooooode/")
                .addPipeline(new ConsolePipeline())
               .run();
    }
}