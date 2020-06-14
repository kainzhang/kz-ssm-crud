package me.lokka.jz.service;

import me.lokka.jz.bean.AccountCustomer;


import java.util.List;

/**
 * @ClassName IAccountCustomerService
 * @Description TODO
 * @Author lenovo
 * @Date 2020/6/14 15:08
 **/

public interface IAccountCustomerService {

    void insert(AccountCustomer accountCustomer);

    List<AccountCustomer> findAll();

    List<AccountCustomer> findAllByUserId(long userId);

}