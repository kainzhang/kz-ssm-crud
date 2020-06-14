package me.lokka.jz.service;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.extend.OrderExtend;
import me.lokka.jz.utils.CustomerException;
import me.lokka.jz.vm.OrderVM;

import java.util.List;

/**
 * @Interface: IAddressService
 * @Descr: 订单业务接口
 * @Author: LOKKA
 * @Date: 2020/6/12 18:36
 **/

public interface IOrderService {

    void commit(OrderVM orderVM) throws CustomerException;

    List<Order> findAll();

    /**
     * @Descr 通过 订单ID 查询详细信息
     * @param id
     * @return
     */
    OrderExtend findOrderDetailsById(long id);

    /**
     * @Descr 通过 订单状态 查询信息
     * @param status
     * @return
     */
    List<Order> findByStatus(String status);

    /**
     * @Descr 通过 订单顾客ID 查询信息
     * @param customerId
     * @return
     */
    List<Order> findByCustomer(long customerId);

    /**
     *  @Descr 通过 员工ID 查询信息
     * @param employeeId
     * @return
     */
    List<Order> findByEmployee(long employeeId);

    /**
     * @Descr 通过 顾客ID + 订单状态 查询信息
     * @param customerId
     * @param status
     * @return
     */
    List<Order> findByCustomerAndStatus(long customerId, String status);

    /**
     * @Descr 通过 员工ID + 订单状态 查询信息
     * @param employeeId
     * @param status
     * @return
     */
    List<Order> findByEmployeeAndStatus(long employeeId, String status);

    /**
     * @Descr 通过 起止时间 查询信息
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Order> findByDate(long fromDate, long toDate);

    /**
     * @Descr 通过 顾客ID + 起止日期 查询信息
     * @param customerId
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Order> findByCustomerAndDate(long customerId, long fromDate, long toDate);

    /**
     * @Descr 通过 员工ID + 起止日期 查询信息
     * @param employeeId
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Order> findByEmployeeAndDate(long employeeId, long fromDate, long toDate);

    /**
     * @Descr 通过 顾客ID + 起止日期 + 订单状态 查询信息
     * @param customerId
     * @param fromDate
     * @param toDate
     * @param status
     * @return
     */
    List<Order> findByCustomerAndDateAndStatus(long customerId, long fromDate, long toDate, String status);

    /**
     * @Descr 通过 员工ID + 起止日期 + 订单状态 查询信息
     * @param employeeId
     * @param fromDate
     * @param toDate
     * @param status
     * @return
     */
    List<Order> findByEmployeeAndDateAndStatus(long employeeId, long fromDate, long toDate, String status);

    /**
     * @Descr 通过 订单ID 修改 订单状态
     * @param id
     * @param status
     * @throws CustomerException
     */
    void editOrderStatus(long id, String status) throws CustomerException;

}
