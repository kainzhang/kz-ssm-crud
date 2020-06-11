package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.CategoryExample;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.dao.CategoryMapper;
import me.lokka.jz.dao.extend.CategoryExtendMapper;
import me.lokka.jz.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category findById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(Category category) {
        if (category.getId() == null)
            categoryMapper.insert(category);
        else
            categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public List<CategoryExtend> findCategoryTree() {
        return categoryExtendMapper.selectCategoryTree();
    }
}
