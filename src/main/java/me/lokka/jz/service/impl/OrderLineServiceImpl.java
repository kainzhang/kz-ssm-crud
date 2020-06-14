package me.lokka.jz.service.impl;

import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.OrderLineExample;
import me.lokka.jz.bean.extend.OrderLineExtend;
import me.lokka.jz.dao.OrderLineMapper;
import me.lokka.jz.dao.extend.OrderLineExtendMapper;
import me.lokka.jz.service.IOrderLineService;
import me.lokka.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Class: OrderLineServiceImpl
 * @Descr: 订单项业务实现类
 * @Author: LOKKA
 * @Date: 2020/6/15 1:00
 **/

@Service
public class OrderLineServiceImpl implements IOrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderLineExtendMapper orderLineExtendMapper;

    /**
     * @return
     * @Descr 获取所有订单项
     */
    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example = new OrderLineExample();
        example.setOrderByClause("id desc");
        return orderLineMapper.selectByExample(example);
    }

    /**
     * @return
     * @Descr 获取所有订单项 + 产品信息
     */
    @Override
    public List<OrderLineExtend> findAllWithProduct() {
        return orderLineExtendMapper.selectAllWithProduct();
    }

    /**
     * @param orderId
     * @return
     * @Descr 通过 订单ID 搜索 订单项
     */
    @Override
    public List<OrderLine> findByOrderId(long orderId) {
        OrderLineExample example = new OrderLineExample();
        OrderLineExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderLineMapper.selectByExample(example);
    }

    /**
     * @param productId
     * @return
     * @Descr 通过 产品ID 搜索 订单项
     */
    @Override
    public List<OrderLine> findByProductId(long productId) {
        OrderLineExample example = new OrderLineExample();
        OrderLineExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(productId);
        return orderLineMapper.selectByExample(example);
    }

    /**
     * @param id
     * @return
     * @Descr 通过 订单项ID 搜索订单项详情
     */
    @Override
    public OrderLineExtend findById(long id) {
        return orderLineExtendMapper.selectById(id);
    }

    /**
     * @param orderLine
     * @throws CustomerException
     * @Descr 添加订单项 或通过 订单项ID 修改订单项
     */
    @Override
    public void saveOrEdit(OrderLine orderLine) throws CustomerException {
        if (orderLine.getId() == null) {
            orderLineMapper.insert(orderLine);
        } else {
            OrderLine orderLineT = orderLineMapper.selectByPrimaryKey(orderLine.getId());
            if (orderLineT == null) {
                throw new CustomerException("修改失败，订单项不存在");
            }
            orderLineMapper.updateByPrimaryKey(orderLine);
        }
    }

    /**
     * @param id
     * @throws CustomerException
     * @Descr 通过 订单项ID 删除订单项
     */
    @Override
    public void delById(long id) throws CustomerException {
        OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
        if (orderLine == null) {
            throw new CustomerException("删除失败，订单项不存在");
        }
        orderLineMapper.deleteByPrimaryKey(id);
    }
}