package me.lokka.jz.bean.extend;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.User;

import java.util.List;

public class OrderExtend extends Order {
    public static final String STATUS_UNPAID = "未付款";
    public static final String STATUS_PAID = "已付款";
    public static final String STATUS_PROCESSIN = "处理中";
    public static final String STATUS_DONE = "已完成";

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


