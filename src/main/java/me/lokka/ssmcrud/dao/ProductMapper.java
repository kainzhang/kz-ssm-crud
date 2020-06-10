package me.lokka.ssmcrud.dao;

import me.lokka.ssmcrud.bean.Product;
import me.lokka.ssmcrud.bean.extend.ProductExtend;

import java.util.List;

public interface ProductMapper {

    List<ProductExtend> selectAll();

    List<Product> selectByCategoryId(long categoryId);

    void insert(Product product);

    void update(Product product);

    void deleteById(long id);
}
