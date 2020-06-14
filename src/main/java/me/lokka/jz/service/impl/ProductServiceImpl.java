package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.ProductExample;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.dao.ProductMapper;
import me.lokka.jz.dao.extend.ProductExtendMapper;
import me.lokka.jz.service.IProductService;
import me.lokka.jz.utils.CustomerException;
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
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return productMapper.selectByExample(example);
    }

    @Override
    public void saveOrEdit(Product product) throws CustomerException {
        if (product.getId() == null) {
            productMapper.insert(product);
        } else {
            Product productT = productMapper.selectByPrimaryKey(product.getId());
            if (productT == null) {
                throw new CustomerException("修改失败，数据不存在");
            }
            productMapper.updateByPrimaryKey(product);
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        productMapper.deleteByPrimaryKey(id);
    }
}
