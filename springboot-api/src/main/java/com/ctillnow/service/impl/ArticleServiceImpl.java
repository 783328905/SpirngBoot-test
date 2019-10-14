package com.ctillnow.service.impl;

import com.ctillnow.bean.Article;
import com.ctillnow.mapper.ArticleMapper;
import com.ctillnow.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by caiping on 2019/10/14.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;


    /**
     *@Cacheable : 这个注解是在方法运行之前检查缓存中是否存在指定的key的数据，如果存在，那么直接返回
     *              如果不存在，那么执行方法体，最后将方法体返回的结果添加到缓存中
     *           1、 cacheNames/value : 指定cache的名字,指定将方法的返回值放在那个缓存中，是数组的方式
     *           2、key : 指定缓存的key，如果不指定的，那么默认使用方法参数的值，当然也是可以使用一些表达式指定这个key的值
     *              1、spEL表达式：
     *                  1、当前被调用的方法名称 ---- #root.methodName  ---- #root.method.name
     *                  2、当前目标对象  ---- #root.target
     *                  3、当前目标对象的类  ----- #root.targetClass
     *                  4、当前被调用对象的参数列表  ---- #root.args[index]
     *                  5、方法参数的名字，直接使用`#名字`即可获取参数的值  ------ `#userId`
     *                  6、方法的返回值    -----    #result
     *           3、keyGenerator : key的生成器，这个和key只能同时指定一个，当然也是可以自定义这个生成器
     *           4、condition :  指定缓存的条件，只有满足这个条件的时候才会使用缓存 --- condition = "#userId>2"
     *           5、unless :  当这个条件为true的时候就不缓存，这个和condition条件相反。
     *                      1、这个可以使用返回的结果进行判断，比如当我们对返回结果为空的时候不使用缓存，那么可以写成unless = "#result==null"
     *
     *           6、cacheManager : 指定缓存管理器
     *           7、sync ： 是否使用异步模式
     *           8、注意：springBoot默认是将返回值为null的时候也会将其缓存起来，我们可以使用unless条件对结果进行判断是否缓存
     *
     *
     */
    @Cacheable(value = {"article"},key = "#id",condition = "#id>0",unless = "#result==null")
    @Override
    public Article getArticleById(Integer id) {
        System.out.println("--------从数据库中读取------");
        return articleMapper.selectArticle(id);
    }

    @CachePut(value="article",key="#article.id")
    @Override
    public Article addArticle(Article article) {
        article.setCreateTime(new Date());
        article.setSubmitTime(new Date());
        article.setLastUpdateTime(new Date());
        articleMapper.insertArticle(article);
        return article;
    }

    @CacheEvict(value = "article",key="#id")
    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);

    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "article",key = "author")
            },
            put = {
                    @CachePut(value = "article",key = "result.id"),
                    @CachePut(value = "article",key = "result.title"),
            }

    )
    @Override
    public Article getArticleByAuthor(String author) {
        return articleMapper.getArticleByAuthor( author);
    }


}
