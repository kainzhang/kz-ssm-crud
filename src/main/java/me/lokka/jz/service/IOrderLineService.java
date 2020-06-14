package me.lokka.jz.service;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.bean.extend.OrderLineExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

/**
 * @Interface: IOrderLineService
 * @Descr: 订单项业务接口
 * @Author: LOKKA
 * @Date: 2020/6/15 0:53
 **/

public interface IOrderLineService {

    /**
     * @Descr 获取所有订单项
     * @return
     */
    List<OrderLine> findAll();

    /**
     * @Descr 获取所有订单项 + 产品信息
     * @return
     */
    List<OrderLineExtend> findAllWithProduct();

    /**
     * @Descr 通过 订单ID 搜索 订单项
     * @param orderId
     * @return
     */
    List<OrderLine> findByOrderId(long orderId);

    /**
     * @Descr 通过 产品ID 搜索 订单项
     * @param productId
     * @return
     */
    List<OrderLine> findByProductId(long productId);

    /**
     * @Descr 通过 订单项ID 搜索订单项详情
     * @param id
     * @return
     */
    OrderLineExtend findById(long id);

    /**
     * @Descr 添加订单项 或通过 订单项ID 修改订单项
     * @param orderLine
     * @throws CustomerException
     */
    void saveOrEdit(OrderLine orderLine) throws CustomerException;

    /**
     * @Descr 通过 订单项ID 删除订单项
     * @param id
     * @throws CustomerException
     */
    void delById(long id) throws CustomerException;

}