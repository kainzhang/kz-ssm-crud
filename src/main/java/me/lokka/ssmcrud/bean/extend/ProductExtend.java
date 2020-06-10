package me.lokka.ssmcrud.bean.extend;

import me.lokka.ssmcrud.bean.Category;
import me.lokka.ssmcrud.bean.Product;

public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
