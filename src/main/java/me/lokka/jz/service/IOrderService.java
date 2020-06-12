package me.lokka.jz.service;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.extend.OrderExtend;
import me.lokka.jz.utils.CustomerException;
import me.lokka.jz.vm.OrderVM;

import java.util.List;

public interface IOrderService {

    void commit(OrderVM orderVM) throws CustomerException;

    List<Order> findAll();

    OrderExtend findOrderDetailsById(long id);

}
