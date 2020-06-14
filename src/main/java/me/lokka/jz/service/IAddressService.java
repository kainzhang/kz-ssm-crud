package me.lokka.jz.service;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.Category;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.bean.extend.CategoryExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

/**
 * @Interface: IAddressService
 * @Descr: 地址业务接口
 * @Author: LOKKA
 * @Date: 2020/6/14 9:47
 **/

public interface IAddressService {

    List<Address> findAll();

    List<AddressExtend> findAllWithUser();

    List<Address> findByUserId(long userId);

    Address findById(long id);

    void saveOrEdit(Address address) throws CustomerException;

    void delById(long id) throws CustomerException;

}