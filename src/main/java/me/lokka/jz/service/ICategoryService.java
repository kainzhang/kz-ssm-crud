package me.lokka.jz.service;


import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.CategoryExtend;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(long id);

    void saveOrEdit(Category category);

    void delById(long id);

    List<CategoryExtend> findAllWithChild();
}
