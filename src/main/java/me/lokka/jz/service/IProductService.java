package me.lokka.jz.service;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.ProductExtend;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<ProductExtend> findAllWithCategory();

    List<Product> findByCategoryId(long categoryId);

    void saveOrEdit(Product product);

    void delById(long id);
}
