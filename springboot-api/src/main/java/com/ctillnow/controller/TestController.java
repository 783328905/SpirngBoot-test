package com.ctillnow.controller;


import com.ctillnow.bean.Article;
import com.ctillnow.bean.User;
import com.ctillnow.myannotation.PrintLog;
import com.ctillnow.service.ArticleService;
import com.ctillnow.util.TimeUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by caiping on 2019/10/12.
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    ArticleService articleService;


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

    @RequestMapping("/user")
    @ResponseBody
    public String getUser(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()){
            return result.getFieldError().getDefaultMessage();
        }
        return user.toString();

    }

    @PostMapping("/add_article")
    @ResponseBody
    public Article addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    @GetMapping("/get_article")
    @ResponseBody
    public Article getArticle(Integer id){
        return articleService.getArticleById(id);
    }

    @DeleteMapping("del_article")
    @ResponseBody
    public void deleteArticle(Integer id){
         articleService.deleteArticle(id);
    }




}



