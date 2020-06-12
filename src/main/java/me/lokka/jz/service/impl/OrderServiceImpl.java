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
            // 设置order与orderline之间的关键（外键维护）
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }

    }

    @Override
    public List<Order> findAll() {
        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public OrderExtend findOrderDetailsById(long id) {
        return orderExtendMapper.selectById(id);
    }

}
