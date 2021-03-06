package com.ctillnow.schedule;

import com.ctillnow.pipline.NewsPipeline;
import com.ctillnow.processor.JianShuProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * Created by caiping on 2019/10/23.
 */

@Component
public class NewsScheduled {

    @Autowired
    private NewsPipeline newsPipeline;

    @Scheduled(fixedRate = 12000)//从0点开始,每2个小时执行一次
    public void jianShuScheduled() {
        System.out.println("----开始执行简书定时任务");
        Spider spider = Spider.create(new JianShuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(newsPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }


}
