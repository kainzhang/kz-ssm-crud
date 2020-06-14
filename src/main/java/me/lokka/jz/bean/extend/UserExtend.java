package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Role;
import me.lokka.jz.bean.User;

public class UserExtend extends User {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
