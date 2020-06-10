package me.lokka.ssmcrud.service.impl;

import me.lokka.ssmcrud.bean.Product;
import me.lokka.ssmcrud.dao.ProductMapper;
import me.lokka.ssmcrud.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> findByCategoryId(long categoryId) {
        return productMapper.selectByCategoryId(categoryId);
    }

    @Override
    public void saveOrEdit(Product product) {
        if (product.getId() == null)
            productMapper.insert(product);
        else
            productMapper.update(product);
    }

    @Override
    public void delById(long id) {
        productMapper.deleteById(id);
    }
}
