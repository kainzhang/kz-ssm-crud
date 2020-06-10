package me.lokka.ssmcrud.web.controller;

import me.lokka.ssmcrud.bean.Article;
import me.lokka.ssmcrud.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @GetMapping("findAll")
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("findById")
    public Article findById(Long id) {
        return articleService.findById(id);
    }

    @GetMapping("deleteById")
    public String deleteById(Long id) {
        articleService.deleteById(id);
        return "删除成功";
    }

    @PostMapping("save")
    public String save(Article article) {
        articleService.save(article);
        return "保存成功";
    }

    @PostMapping("update")
    public String update(Article article) {
        return "success";
    }
}
