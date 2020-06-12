package me.lokka.jz.web.controller;

import io.swagger.annotations.*;
import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.service.IProductService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "产品管理接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<Product> list = productService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取全部+类别信息")
    @GetMapping("find_all_with_category")
    public Message findAllWithCategory() {
        List<ProductExtend> list = productService.findAllWithCategory();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过类别ID查找")
    @ApiImplicitParam(name = "categoryId", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_category_id")
    public Message findByCategory(long categoryId) {
        List<Product> list = productService.findByCategoryId(categoryId);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(Product product) {
        productService.saveOrEdit(product);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id", value = "产品唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        productService.delById(id);
        return MessageUtil.success("删除成功");
    }
}
