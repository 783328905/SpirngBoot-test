package com.ctillnow.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


/**
 * Created by caiping on 2019/10/15.
 */
public class RabbitMQConfig {
    public static final String QUEUE = "direct_queue";

    @Bean
    public Queue directQueue(){
        return  new Queue(QUEUE,true);
    }
}
