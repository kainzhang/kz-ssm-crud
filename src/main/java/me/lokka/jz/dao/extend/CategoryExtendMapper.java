package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.dao.CategoryMapper;

import java.util.List;

public interface CategoryExtendMapper extends CategoryMapper {

    List<CategoryExtend> selectAllWithChild();

    List<Category> selectByParentId(long id);

}
