package me.lokka.jz.web.controller;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.service.ICategoryService;
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

    @GetMapping("find_all")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("find_all_with_child")
    public List<CategoryExtend> findAllWithChild() {
        return categoryService.findAllWithChild();
    }

    @GetMapping("find_by_id")
    public Category findById(long id) {
        return categoryService.findById(id);
    }

    @PostMapping("save_or_edit")
    public String saveOrEdit(Category category) {
        categoryService.saveOrEdit(category);
        return "SUCCESS";
    }

    @GetMapping("del_by_id")
    public String delById(long id) {
        categoryService.delById(id);
        return "SUCCESS";
    }
}
