package me.lokka.jz.bean.extend;

/**
 * @Class: OrderLineExtend
 * @Descr: OrderLine 扩展类
 * @Author: LOKKA
 * @Date: 2020/6/13 19:31
 **/

import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.Product;

public class OrderLineExtend extends OrderLine {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
