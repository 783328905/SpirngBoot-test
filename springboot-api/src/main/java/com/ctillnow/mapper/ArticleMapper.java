package com.ctillnow.mapper;

import com.ctillnow.bean.Article;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.context.embedded.LocalServerPort;

/**
 * Created by caiping on 2019/10/14.
 */

@Mapper
public interface ArticleMapper {
    @Select("select * from t_articles where id = #{id}")
    public Article selectArticle(int id);

    //@Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into t_articles(id,title,content,digest,author,create_time," +
            "submit_time,last_update_time,city_id,readable,read_count,is_deleted)" +
            "values(#{id},#{title},#{content},#{digest},#{author},#{createTime}," +
            "#{submitTime},#{lastUpdateTime},#{cityId},#{readable},#{readCount},#{isDeleted})")
    public int insertArticle(Article article);

    @Delete("delete from t_articles where id =#{id}")
    void deleteArticle(Integer id);

    @Select("select * from t_articles where author = #{author}")
    Article getArticleByAuthor(String author);
}
