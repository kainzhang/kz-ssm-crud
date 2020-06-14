package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.OrderLineExample;
import me.lokka.jz.bean.extend.OrderLineExtend;

import java.util.List;

public interface OrderLineExtendMapper {

    List<OrderLine> selectByOrderId(long id);

    List<OrderLineExtend> selectAllWithProduct();

    OrderLineExtend selectById(long id);

}
