package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderExample;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.extend.OrderExtend;
import me.lokka.jz.dao.OrderLineMapper;
import me.lokka.jz.dao.OrderMapper;
import me.lokka.jz.dao.extend.OrderExtendMapper;
import me.lokka.jz.service.IOrderService;
import me.lokka.jz.utils.CustomerException;
import me.lokka.jz.vm.OrderVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Class: OrderServiceImpl
 * @Descr: 订单业务实现类
 * @Author: LOKKA
 * @Date: 2020/6/12 18:44
 **/

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;

    @Override
    public void commit(OrderVM orderVM) throws CustomerException {
        /*
         * 1. 分别获取到订单信息 及订单项信息
         * 2. 先保存订单信息
         * 3. 保存订单项信息
         * */
        Order order = new Order();
        order.setTotal(orderVM.getTotal());
        order.setAddressId(orderVM.getAddressId());
        order.setCustomerId(orderVM.getCustomerId());
        order.setEmployeeId(orderVM.getEmployeeId());
        order.setOrderTime(new Date().getTime());
        order.setStatus(OrderExtend.STATUS_UNPAID);

        List<OrderLine> orderLines = orderVM.getOrderLines();

        orderMapper.insert(order);

        for(OrderLine orderLine : orderLines){
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }
    }

    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 订单ID 查询详细信息
     *
     * @param id
     */
    @Override
    public OrderExtend findOrderDetailsById(long id) {
        return orderExtendMapper.selectById(id);
    }

    /**
     * @Descr 通过 订单状态 查询信息
     *
     * @param status
     */
    @Override
    public List<Order> findByStatus(String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 订单顾客ID 查询信息
     *
     * @param customerId
     */
    @Override
    public List<Order> findByCustomer(long customerId) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 员工ID 查询信息
     *
     * @param employeeId
     */
    @Override
    public List<Order> findByEmployee(long employeeId) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 顾客ID + 订单状态 查询信息
     *
     * @param customerId
     * @param status
     */
    @Override
    public List<Order> findByCustomerAndStatus(long customerId, String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 员工ID + 订单状态 查询信息
     *
     * @param employeeId
     * @param status
     */
    @Override
    public List<Order> findByEmployeeAndStatus(long employeeId, String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 起止时间 查询信息
     *
     * @param fromDate
     * @param toDate
     */
    @Override
    public List<Order> findByDate(long fromDate, long toDate) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderTimeBetween(fromDate, toDate);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 顾客ID + 起止日期 查询信息
     *
     * @param customerId
     * @param fromDate
     * @param toDate
     */
    @Override
    public List<Order> findByCustomerAndDate(long customerId, long fromDate, long toDate) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId).andOrderTimeBetween(fromDate, toDate);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 员工ID + 起止日期 查询信息
     *
     * @param employeeId
     * @param fromDate
     * @param toDate
     */
    @Override
    public List<Order> findByEmployeeAndDate(long employeeId, long fromDate, long toDate) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId).andOrderTimeBetween(fromDate, toDate);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 顾客ID + 起止日期 + 订单状态 查询信息
     *
     * @param customerId
     * @param fromDate
     * @param toDate
     * @param status
     */
    @Override
    public List<Order> findByCustomerAndDateAndStatus(long customerId, long fromDate, long toDate, String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId).andOrderTimeBetween(fromDate, toDate).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 员工ID + 起止日期 + 订单状态 查询信息
     *
     * @param employeeId
     * @param fromDate
     * @param toDate
     * @param status
     */
    @Override
    public List<Order> findByEmployeeAndDateAndStatus(long employeeId, long fromDate, long toDate, String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId).andOrderTimeBetween(fromDate, toDate).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @Descr 通过 订单ID 修改 订单状态
     *
     * @param id
     * @param status
     */
    @Override
    public void editOrderStatus(long id, String status) throws CustomerException{
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null) {
            throw new CustomerException("订单不存在");
        }
        order.setStatus(status);
        orderMapper.updateByPrimaryKey(order);
    }

}
