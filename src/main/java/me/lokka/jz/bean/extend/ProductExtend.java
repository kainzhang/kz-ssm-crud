package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.Product;

public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
