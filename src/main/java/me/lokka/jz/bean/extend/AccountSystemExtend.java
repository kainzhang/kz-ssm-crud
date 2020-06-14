package me.lokka.jz.bean.extend;
import me.lokka.jz.bean.AccountSystem;
import me.lokka.jz.bean.User;

/**
 * @ClassName AccountSystemExtend
 * @Description TODO
 * @Author wangzhenxing
 * @Date 2020/6/14 17:47
 **/
public class AccountSystemExtend extends AccountSystem {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}