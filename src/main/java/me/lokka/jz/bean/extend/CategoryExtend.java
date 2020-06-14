package me.lokka.jz.bean.extend;


import me.lokka.jz.bean.Category;

import java.util.List;


public class CategoryExtend extends Category {
    private List<Category> child;

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }
}
