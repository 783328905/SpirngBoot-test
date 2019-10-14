package com.ctillnow.start;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by caiping on 2019/10/14.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringbootCacheApplicationTests {
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;  //存储key和value都是字符串的数据
//
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate; //操作key和value都是Object的数据
//
//    @Test
//    public void contextLoads() {
//        stringRedisTemplate.opsForValue().append("hello","hello world");
//    }
//
//}