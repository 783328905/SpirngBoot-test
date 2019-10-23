package com.ctillnow.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiping on 2019/10/15.
 */

@Component

public class AsyncTask {

    @Async
    public void task() throws InterruptedException {
        long current  = System.currentTimeMillis();
        Thread.sleep(1000);
        long current1 = System.currentTimeMillis();

        System.out.println("task任务耗时"+(current1-current)+"ms");

    }
    @Async
    public void task1() throws InterruptedException {
        long current  = System.currentTimeMillis();
        Thread.sleep(1000);
        long current1 = System.currentTimeMillis();

        System.out.println("task1任务耗时"+(current1-current)+"ms");

    }

    @Async
    public void task2() throws InterruptedException {
        long current  = System.currentTimeMillis();
        Thread.sleep(1000);
        long current1 = System.currentTimeMillis();

        System.out.println("task2任务耗时"+(current1-current)+"ms");

    }

}
