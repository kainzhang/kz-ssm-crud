package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.OrderLine;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.bean.extend.OrderLineExtend;
import me.lokka.jz.service.IAddressService;
import me.lokka.jz.service.IOrderLineService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Class: OrderLineController
 * @Descr: 订单项控制器
 * @Author: LOKKA
 * @Date: 2020/6/15 1:14
 **/

@Api(description = "订单项管理接口")
@RestController
@RequestMapping("/orderline")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<OrderLine> list = orderLineService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取全部 + 产品信息")
    @GetMapping("find_all_with_product")
    public Message findAllWithProduct() {
        List<OrderLineExtend> list = orderLineService.findAllWithProduct();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过订单ID搜索信息")
    @ApiImplicitParam(name = "orderId", value = "订单唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_order_id")
    public Message findByOrderId(long orderId) {
        List<OrderLine> list = orderLineService.findByOrderId(orderId);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过产品ID搜索信息")
    @ApiImplicitParam(name = "productId", value = "产品唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_product_id")
    public Message findByProductId(long productId) {
        List<OrderLine> list = orderLineService.findByProductId(productId);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过订单项ID获取详细信息")
    @ApiImplicitParam(name = "id", value = "订单项唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        OrderLineExtend orderLineExtend = orderLineService.findById(id);
        return MessageUtil.success(orderLineExtend);
    }

    @ApiOperation(value = "添加或通过ID修改信息")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(OrderLine orderLine) {
        orderLineService.saveOrEdit(orderLine);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过ID删除信息")
    @ApiImplicitParam(name = "id", value = "订单项唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        orderLineService.delById(id);
        return MessageUtil.success("删除成功");
    }
}