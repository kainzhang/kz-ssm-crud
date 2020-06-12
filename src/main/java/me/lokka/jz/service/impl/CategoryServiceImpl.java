package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.CategoryExample;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.dao.CategoryMapper;
import me.lokka.jz.dao.extend.CategoryExtendMapper;
import me.lokka.jz.service.ICategoryService;
import me.lokka.jz.utils.CustomerException;
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
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }

    @Override
    public Category findById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(Category category) {
        if (category.getId() == null) {
            categoryMapper.insert(category);
        } else {
            Category categoryT = categoryMapper.selectByPrimaryKey(category.getId());
            if (categoryT == null) {
                throw new CustomerException("修改失败，数据不存在");
            }
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

}
