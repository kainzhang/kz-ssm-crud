package me.lokka.ssmcrud.dao;

import me.lokka.ssmcrud.bean.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> selectAll();

    List<Product> selectByCategoryId(long categoryId);

    void insert(Product product);

    void update(Product product);

    void deleteById(long id);
}
