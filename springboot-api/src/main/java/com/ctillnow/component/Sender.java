package com.ctillnow.component;

import com.ctillnow.bean.User;
import com.ctillnow.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by caiping on 2019/10/15.
 */
//@Component
//public class Sender {
//    @Autowired
//    private AmqpTemplate amqpTemplate;
//    public void sendDirectQueue(User user){
//
//        System.out.println("[消息已发送]");
//        this.amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE,user);
//    }
//}
