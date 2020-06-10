package me.lokka.ssmcrud.service.impl;

import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.extend.CategoryExtend;
import me.lokka.ssmcrud.dao.CategoryMapper;
import me.lokka.ssmcrud.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }

    /**
     * 保存
     *
     * @param category
     */
    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }

    /**
     * 查询栏目树
     *
     * @return
     */
    @Override
    public List<CategoryExtend> findCategoryTree() {
        return categoryMapper.selectCategoryTree();
    }
}
