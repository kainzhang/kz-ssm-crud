package me.lokka.jz.service;


import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    List<CategoryExtend> findAllWithChild();

    Category findById(long id);

    void saveOrEdit(Category category) throws CustomerException;

    void delById(long id) throws CustomerException;
}
