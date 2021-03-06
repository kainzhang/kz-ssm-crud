package me.lokka.jz.service;

import me.lokka.jz.bean.RolePrivilege;
import me.lokka.jz.bean.extend.RolePrivilegeExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface IRolePrivilegeService {

    List<RolePrivilege> findAll();

    List<RolePrivilegeExtend> findAllWithRoleAndPrivilege();

    RolePrivilege findById(long id);

    void saveOrEdit(RolePrivilege rolePrivilege) throws CustomerException;

    void delById(long id) throws CustomerException;
}