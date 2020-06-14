package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.bean.User;

/**
 * @ClassName AccountEmployeeExtend
 * @Description
 * @Author lenovo
 * @Date 2020/6/14 19:39
 **/
public class AccountEmployeeExtend extends AccountEmployee {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}