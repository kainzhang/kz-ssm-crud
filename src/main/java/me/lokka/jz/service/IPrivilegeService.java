package me.lokka.jz.service;

import me.lokka.jz.bean.Privilege;
import me.lokka.jz.bean.extend.PrivilegeExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface IPrivilegeService {

    List<Privilege> findAll();

    List<PrivilegeExtend> findAllWithChild();

    Privilege findById(long id);

    void saveOrEdit(Privilege privilege) throws CustomerException;

    void delById(long id) throws CustomerException;

}