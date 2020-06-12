package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.OrderLine;

import java.util.List;

public interface OrderLineExtendMapper {

    List<OrderLine> selectByOrderId(long id);

}
