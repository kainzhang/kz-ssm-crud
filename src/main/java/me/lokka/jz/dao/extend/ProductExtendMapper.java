package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.dao.ProductMapper;

import java.util.List;

public interface ProductExtendMapper extends ProductMapper {

    List<ProductExtend> selectAllWithCategory();

}
