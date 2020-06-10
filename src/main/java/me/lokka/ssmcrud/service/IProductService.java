package me.lokka.ssmcrud.service;

import me.lokka.ssmcrud.bean.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<Product> findByCategoryId(long categoryId);

    void saveOrEdit(Product product);

    void delById(long id);
}
