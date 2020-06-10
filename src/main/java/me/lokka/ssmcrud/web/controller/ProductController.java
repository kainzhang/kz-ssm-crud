package me.lokka.ssmcrud.web.controller;

import me.lokka.ssmcrud.bean.Product;
import me.lokka.ssmcrud.bean.extend.ProductExtend;
import me.lokka.ssmcrud.service.IProductService;
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

    @GetMapping("findAll")
    public List<ProductExtend> findAll() {
        return productService.findAll();
    }

    @GetMapping("findByCategory")
    public List<Product> findByCategory(long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @PostMapping("saveOrEdit")
    public String saveOrEdit(Product product) {
        productService.saveOrEdit(product);
        return "SUCCESS";
    }

    @GetMapping("delById")
    public String delById(long id) {
        productService.delById(id);
        return "SUCCESS";
    }
}
