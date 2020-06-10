package me.lokka.ssmcrud.service;


import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.extend.CategoryExtend;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(long id);

    void save(Category category);

    List<CategoryExtend> findCategoryTree();
}
