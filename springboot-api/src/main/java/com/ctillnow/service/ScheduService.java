package com.ctillnow.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by caiping on 2019/10/14.
 */
@Service
public class ScheduService {

    //@Scheduled(cron = "0/1 * * * * ?")
    @Scheduled(fixedRate = 6000)
    public void sayHello(){
        System.out.println("say hello");
    }
}
