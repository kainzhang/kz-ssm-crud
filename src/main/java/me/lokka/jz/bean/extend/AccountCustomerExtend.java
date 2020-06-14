package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.AccountCustomer;
import me.lokka.jz.bean.User;

/**
 * @ClassName AccountCustomerExtend
 * @Description
 * @Author lenovo
 * @Date 2020/6/14 19:17
 **/

public class AccountCustomerExtend extends AccountCustomer {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}