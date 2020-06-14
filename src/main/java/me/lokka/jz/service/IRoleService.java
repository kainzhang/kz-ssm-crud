package me.lokka.jz.service;

import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.Role;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

//    List<Role> findAllWithChild();

    Role findById(long id);

    void saveOrEdit(Role role) throws CustomerException;

    void delById(long id) throws CustomerException;

}