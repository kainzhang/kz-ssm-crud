package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.extend.RolePrivilegeExtend;

import java.util.List;

public interface RolePrivilegeExtendMapper {

    List<RolePrivilegeExtend> selectAllWithRoleAndPrivilege();

}