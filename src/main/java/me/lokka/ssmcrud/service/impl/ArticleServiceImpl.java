package me.lokka.ssmcrud.service.impl;

import me.lokka.ssmcrud.bean.Article;
import me.lokka.ssmcrud.dao.ArticleMapper;
import me.lokka.ssmcrud.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;    // 依赖注入

    @Override
    public List<Article> findAll() {
        return articleMapper.selectAll();
    }

    @Override
    public Article findById(long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public void save(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public void deleteById(long id) {
        articleMapper.deleteById(id);
    }
}
