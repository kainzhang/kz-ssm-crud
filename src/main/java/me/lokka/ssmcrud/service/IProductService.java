package me.lokka.ssmcrud.service;

import me.lokka.ssmcrud.bean.Product;
import me.lokka.ssmcrud.bean.extend.ProductExtend;

import java.util.List;

public interface IProductService {

    List<ProductExtend> findAll();

    List<Product> findByCategoryId(long categoryId);

    void saveOrEdit(Product product);

    void delById(long id);
}
