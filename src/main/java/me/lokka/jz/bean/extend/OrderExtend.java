package me.lokka.jz.bean.extend;

/**
 * @Class: OrderExtend
 * @Descr: Order 扩展类
 * @Author: LOKKA
 * @Date: 2020/6/13 19:30
 **/

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.User;

import java.util.List;

public class OrderExtend extends Order {
    public static final String STATUS_WFK = "未付款";
    public static final String STATUS_DPD = "待派单";
    public static final String STATUS_DFW = "待服务";
    public static final String STATUS_DQR = "待确认";
    public static final String STATUS_YWC = "已完成";

    private User customer;
    private User employee;
    private Address address;
    private List<OrderLine> orderLines;

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
