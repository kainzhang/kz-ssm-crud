package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Privilege;
import me.lokka.jz.bean.Role;
import me.lokka.jz.bean.RolePrivilege;

public class RolePrivilegeExtend extends RolePrivilege {
    private Role role;
    private Privilege privilege;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}