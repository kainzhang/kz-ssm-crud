package me.lokka.ssmcrud.web.controller;

import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.extend.CategoryExtend;
import me.lokka.ssmcrud.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("findById")
    public Category findById(long id) {
        return categoryService.findById(id);
    }

    @PostMapping("save")
    public String save(Category category) {
        categoryService.save(category);
        return "SUCCESS";
    }

    @GetMapping("findCategoryTree")
    public List<CategoryExtend> findCategoryTree() {
        return categoryService.findCategoryTree();
    }
}
