package me.lokka.ssmcrud.dao;


import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryMapper {

    List<Category> selectAll();

    void insert(Category category);

    List<CategoryExtend> selectCategoryTree();

    List<Category> selectByParentId(long id);
}
