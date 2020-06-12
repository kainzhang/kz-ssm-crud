package me.lokka.jz.bean.extend;

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
