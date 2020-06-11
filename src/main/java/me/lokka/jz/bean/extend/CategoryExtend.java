package me.lokka.jz.bean.extend;


import me.lokka.jz.bean.Category;

import java.util.List;


public class CategoryExtend extends Category {
    private List<Category> child;

    public List<Category> getChildren() {
        return child;
    }

    public void setChildren(List<Category> children) {
        this.child = child;
    }
}
