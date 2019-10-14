package com.ctillnow.service;

import com.ctillnow.bean.Article;

/**
 * Created by caiping on 2019/10/14.
 */
public interface ArticleService {

    public Article getArticleById(Integer id);
    public Article addArticle(Article article);
    public void deleteArticle(Integer id);
    public Article getArticleByAuthor(String author);

}
