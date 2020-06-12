package me.lokka.jz.vm;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderLine;

import java.util.List;

public class OrderVM extends Order {
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
