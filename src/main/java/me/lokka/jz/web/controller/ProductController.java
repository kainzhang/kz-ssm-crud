package me.lokka.jz.web.controller;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("find_all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("find_all_with_category")
    public List<ProductExtend> findAllWithCategory() {
        return productService.findAllWithCategory();
    }

    @GetMapping("find_by_category_id")
    public List<Product> findByCategory(long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @PostMapping("save_or_edit")
    public String saveOrEdit(Product product) {
        productService.saveOrEdit(product);
        return "SUCCESS";
    }

    @GetMapping("del_by_id")
    public String delById(long id) {
        productService.delById(id);
        return "SUCCESS";
    }
}
