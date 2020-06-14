package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.User;

/**
 * @Class: AddressExtend
 * @Descr: Address 扩展类
 * @Author: LOKKA
 * @Date: 2020/6/14 9:54
 **/

public class AddressExtend extends Address {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}