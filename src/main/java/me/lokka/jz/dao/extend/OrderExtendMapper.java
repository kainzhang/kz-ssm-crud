package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.extend.OrderExtend;

import java.util.List;

/**
 * @Interface: OrderExtendMapper
 * @Descr: 订单接口
 * @Author: LOKKA
 * @Date: 2020/6/12 18:57
 **/

public interface OrderExtendMapper {

    OrderExtend selectDetailsById(Long id);

    List<OrderExtend> query(String status, Long fromDate, Long toDate);

}
