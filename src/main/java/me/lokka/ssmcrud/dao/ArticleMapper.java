package me.lokka.ssmcrud.dao;

import me.lokka.ssmcrud.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {

    @Results(
            @Result(property = "publishTime", column = "publish_time")
    )
    @Select("select * from cms_article")
    List<Article> selectAll();

    @Select("select * from cms_article where id = #{id}")
    Article selectById(long id);

    @Insert("insert into cms_article(id,title,publish_time) values(null,#{title},#{publishTime})")
    void insert(Article article);

    @Delete("delete from cms_article where id = #{id}")
    void deleteById(long id);
}
