package com.ctillnow.pipline;

import com.ctillnow.bean.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.Map;
/**
 * Created by caiping on 2019/10/23.
 */
@Component
public class NewsPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("news")) {
                News news=(News) entry.getValue();

               System.out.println("-------------"+news.toString());
                    //newsRepository.saveAndFlush(news);

            }

        }
    }
}
