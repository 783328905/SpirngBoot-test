package com.ctillnow.component;

import com.ctillnow.bean.User;
import com.ctillnow.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by caiping on 2019/10/15.
 */
//@Component
//public class Receiver {
//
//    @RabbitListener(queues = RabbitMQConfig.QUEUE)
//    public void  receiverDirectQueue(User user){
//        System.out.println("【receiveDirectQueue】监听到消息"+user.toString());
//    }
//}
