package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderExample;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.OrderExtend;
import me.lokka.jz.dao.OrderLineMapper;
import me.lokka.jz.dao.OrderMapper;
import me.lokka.jz.dao.UserMapper;
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
    private UserMapper userMapper;
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
        order.setStatus(OrderExtend.STATUS_WFK);

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

    @Override
    public List<OrderExtend> query(String status, Long fromDate, Long toDate) {
        if (fromDate == null) {
            fromDate = (long) 0;
        } else if (toDate == null) {
            toDate = new Date().getTime();
        }
        return orderExtendMapper.query(status, fromDate, toDate);
    }

    /**
     * @param id
     * @return
     * @Descr 通过 订单ID 查询详细信息
     */
    @Override
    public OrderExtend findOrderDetailsById(long id) {
        return orderExtendMapper.selectDetailsById(id);
    }

    /**
     * @param status
     * @return
     * @Descr 通过 订单状态 查询信息
     */
    @Override
    public List<OrderExtend> findByStatus(String status) {
        return  orderExtendMapper.query(status, null, null);
    }

    /**
     * @param orderId
     * @throws Exception
     * @Descr 支付订单（进入待派单状态）
     */
    @Override
    public void payOrder(long orderId) throws Exception {
        // 支付订单
        // 省略支付流程...
        // 简化的支付流程
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            throw new Exception("该订单不存在");
        }
        // 进入待派单状态
        order.setStatus(OrderExtend.STATUS_DPD);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * @param orderId
     * @param employeeId
     * @throws Exception
     * @Descr 派单（进入待接单状态->进入待服务状态）
     */
    @Override
    public void sendOrder(long orderId, long employeeId) throws Exception {
        // 派单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null ){
            throw new Exception("该订单不存在");
        }else if (!order.getStatus().equals("待派单") ){
            throw new Exception("订单未支付/订单异常");
        }
        User emp = userMapper.selectByPrimaryKey(employeeId);
        if (emp == null){
            throw new Exception("该员工不存在");
        }
        // 进入待接单状态（省略）->进入待服务状
        order.setStatus(OrderExtend.STATUS_DFW);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * @param orderId
     * @throws Exception
     * @Descr 服务结束（进入待确认状态）（命名错了。。。）
     */
    @Override
    public void rejectOrder(long orderId) throws Exception {
        //服务结束
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null ){
            throw new Exception("该订单不存在");
        }else if (!order.getStatus().equals("待服务")){
            throw new Exception("订单异常");
        }
        // 进入待确认状态
        order.setStatus(OrderExtend.STATUS_DQR);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * @param orderId
     * @throws Exception
     * @Descr　确认订单（进入已完成状态）
     */
    @Override
    public void confirmOrder(long orderId) throws Exception {
        // 顾客确认订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null ){
            throw new Exception("该订单不存在");
        }else if (!order.getStatus().equals("待确认") ){
            throw new Exception("订单异常");
        }
        // 进入已完成状态
        order.setStatus(OrderExtend.STATUS_YWC);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     *                   这是一条分割线
     *  ==================================================
     */

    /**
     * @param customerId
     * @return
     * @Descr 通过 订单顾客ID 查询信息
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
     * @param employeeId
     * @return
     * @Descr 通过 员工ID 查询信息
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
     * @param customerId
     * @param status
     * @return
     * @Descr 通过 顾客ID + 订单状态 查询信息
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
     * @param employeeId
     * @param status
     * @return
     * @Descr 通过 员工ID + 订单状态 查询信息
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
     * @param fromDate
     * @param toDate
     * @return
     * @Descr 通过 起止时间 查询信息
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
     * @param fromDate
     * @param toDate
     * @param status
     * @return
     * @Descr 通过 起止时间 和 订单状态 查询信息
     */
    @Override
    public List<Order> findByDateAndStatus(long fromDate, long toDate, String status) {
        OrderExample example = new OrderExample();
        example.setOrderByClause("order_time desc");
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderTimeBetween(fromDate, toDate).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    /**
     * @param customerId
     * @param fromDate
     * @param toDate
     * @return
     * @Descr 通过 顾客ID + 起止日期 查询信息
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
     * @param employeeId
     * @param fromDate
     * @param toDate
     * @return
     * @Descr 通过 员工ID + 起止日期 查询信息
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
     * @param customerId
     * @param fromDate
     * @param toDate
     * @param status
     * @return
     * @Descr 通过 顾客ID + 起止日期 + 订单状态 查询信息
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
     * @param employeeId
     * @param fromDate
     * @param toDate
     * @param status
     * @return
     * @Descr 通过 员工ID + 起止日期 + 订单状态 查询信息
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
     * @param id
     * @param status
     * @throws CustomerException
     * @Descr 通过 订单ID 修改 订单状态
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
