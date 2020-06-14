package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Privilege;

import java.util.List;

public class PrivilegeExtend extends Privilege{

    private List<Privilege> child;

    public List<Privilege> getChild() {
        return child;
    }

    public void setChild(List<Privilege> child) {
        this.child = child;
    }
}