package com.ctillnow.config;

import com.ctillnow.bean.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by caiping on 2019/10/14.
 */
//@Configuration
//public class RedisConfig {
//
//    //指定自己的RedisTemplate，并且指定默认的序列化器为json的，只需要设置默认的即可，因为value和key的序列化器和默认的是一样的，不需要重复指定
//    @Bean
//    public RedisTemplate<Object, com.ctillnow.Article> redisTemplate(
//            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, com.ctillnow.Article> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        //指定json的序列化器
//        Jackson2JsonRedisSerializer<com.ctillnow.Article> serializer=new Jackson2JsonRedisSerializer<com.ctillnow.Article>(com.ctillnow.Article.class);
//        template.setDefaultSerializer(serializer);  //设置为默认的序列化器
//        return template;
//    }
//}