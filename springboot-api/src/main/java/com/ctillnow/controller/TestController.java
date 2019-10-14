package com.ctillnow.controller;


import com.ctillnow.myannotation.PrintLog;
import com.ctillnow.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by caiping on 2019/10/12.
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("date")
    @ResponseBody
    public String getDate(){


        return TimeUtil.getDate();
    }

    @PrintLog("吃饭")
    @RequestMapping("/annotation")
    @ResponseBody
    public String sayHello(){
        System.out.println("吃饭");
        String s = "";
        return "hello springboot";

    }

}



