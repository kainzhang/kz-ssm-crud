package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.service.ICategoryService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "类别管理接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<Category> list = categoryService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取嵌套结构")
    @GetMapping("find_all_with_child")
    public Message findAllWithChild() {
        List<CategoryExtend> list = categoryService.findAllWithChild();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过ID查找")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        Category category = categoryService.findById(id);
        return MessageUtil.success(category);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(Category category) {
        categoryService.saveOrEdit(category);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        categoryService.delById(id);
        return MessageUtil.success("删除成功");
    }
}
