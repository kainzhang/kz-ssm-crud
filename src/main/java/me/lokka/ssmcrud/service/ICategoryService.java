package me.lokka.ssmcrud.service;


import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.extend.CategoryExtend;

import java.util.List;

public interface ICategoryService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Category> findAll();

    /**
     * 保存
     *
     * @param category
     */
    void save(Category category);

    /**
     * 查询栏目树
     *
     * @return
     */
    List<CategoryExtend> findCategoryTree();
}
