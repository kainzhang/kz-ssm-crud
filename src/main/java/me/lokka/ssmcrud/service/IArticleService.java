package me.lokka.ssmcrud.service;


import me.lokka.ssmcrud.bean.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findAll();

    Article findById(long id);

    void save(Article article);

    void deleteById(long id);
}
