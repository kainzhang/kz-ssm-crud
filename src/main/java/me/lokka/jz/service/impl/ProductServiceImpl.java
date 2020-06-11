package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.ProductExample;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.dao.ProductMapper;
import me.lokka.jz.dao.extend.ProductExtendMapper;
import me.lokka.jz.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductExtendMapper productExtendMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public List<ProductExtend> findAllWithCategory() {
        return productExtendMapper.selectAllWithCategory();
    }

    @Override
    public List<Product> findByCategoryId(long categoryId) {
        return productExtendMapper.selectByCategoryId(categoryId);
    }

    @Override
    public void saveOrEdit(Product product) {
        if (product.getId() == null) {
            productMapper.insert(product);
        } else {
            productMapper.updateByPrimaryKey(product);
        }
    }

    @Override
    public void delById(long id) {
        productMapper.deleteByPrimaryKey(id);
    }
}
