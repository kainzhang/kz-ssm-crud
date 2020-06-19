package me.lokka.jz.service;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<ProductExtend> findAllWithCategory();

    List<ProductExtend> findByName(String name);

    List<Product> findByCategoryId(long categoryId);

    void saveOrEdit(Product product) throws CustomerException;

    void delById(long id) throws CustomerException;
}
