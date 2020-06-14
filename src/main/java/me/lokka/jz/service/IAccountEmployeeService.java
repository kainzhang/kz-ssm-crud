package me.lokka.jz.service;

import me.lokka.jz.bean.AccountCustomer;
import me.lokka.jz.bean.AccountEmployee;

import java.util.List;

/**
 * @ClassName IAccountEmployeeService
 * @Description TODO
 * @Author lenovo
 * @Date 2020/6/14 16:47
 **/

public interface IAccountEmployeeService {

    void insert(AccountEmployee accountEmployee);

    List<AccountEmployee> findAll();

    List<AccountEmployee> findAllByUserId(long userId);

}