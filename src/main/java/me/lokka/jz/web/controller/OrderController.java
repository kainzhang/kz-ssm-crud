package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.extend.OrderExtend;
import me.lokka.jz.service.IOrderService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import me.lokka.jz.vm.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Class: OrderController
 * @Descr: 订单控制器
 * @Author: LOKKA
 * @Date: 2020/6/12 18:49
 **/

@Api(description = "订单管理接口")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @ApiOperation("提交订单")
    @PostMapping("commit")
    public Message commit(@RequestBody OrderVM orderVM){
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }

    @ApiOperation(value = "获取所有订单")
    @GetMapping("find_all")
    public Message findAll(){
        List<Order> list = orderService.findAll();
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过ID查询订单详情")
    @ApiImplicitParam(name = "id", value = "订单唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id){
        OrderExtend orderExtend = orderService.findOrderDetailsById(id);
        return MessageUtil.success("SUCCESS", orderExtend);
    }

    @ApiOperation(value = "通过订单状态查询订单")
    @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    @GetMapping("find_by_status")
    public Message findByStatus(String status) {
        List<Order> list = orderService.findByStatus(status);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过顾客ID查询订单")
    @ApiImplicitParam(name = "customerId", value = "顾客唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_customer")
    public Message findByCustomer(long customerId) {
        List<Order> list = orderService.findByCustomer(customerId);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过员工ID查询订单")
    @ApiImplicitParam(name = "employeeId", value = "员工唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_employee")
    public Message findByEmployee(long employeeId) {
        List<Order> list = orderService.findByEmployee(employeeId);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过顾客ID + 状态查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "顾客唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    })
    @GetMapping("find_by_customer_n_status")
    public Message findByCustomerAndStatus(long customerId, String status) {
        List<Order> list = orderService.findByCustomerAndStatus(customerId, status);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过员工ID + 状态查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    })
    @GetMapping("find_by_employee_n_status")
    public Message findByEmployeeAndStatus(long employeeId, String status) {
        List<Order> list = orderService.findByEmployeeAndStatus(employeeId, status);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过起止日期查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fromDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "toDate", value = "结束日期", required = true, paramType = "query")
    })
    @GetMapping("find_by_date")
    public Message findByDate(long fromDate, long toDate) {
        List<Order> list = orderService.findByDate(fromDate, toDate);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过顾客ID + 起止日期查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "顾客唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fromDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "toDate", value = "结束日期", required = true, paramType = "query")
    })
    @GetMapping("find_by_customer_n_date")
    public Message findByCustomerAndDate(long customerId, long fromDate, long toDate) {
        List<Order> list = orderService.findByCustomerAndDate(customerId, fromDate, toDate);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过员工ID + 起止日期查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fromDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "toDate", value = "结束日期", required = true, paramType = "query")
    })
    @GetMapping("find_by_employee_n_date")
    public Message findByEmployeeAndDate(long employeeId, long fromDate, long toDate) {
        List<Order> list = orderService.findByEmployeeAndDate(employeeId, fromDate, toDate);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过顾客ID + 起止日期 + 订单状态查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "顾客唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fromDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "toDate", value = "结束日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    })
    @GetMapping("find_by_customer_n_date_n_status")
    public Message findByCustomerAndDateAndStatus(long customerId, long fromDate, long toDate, String status) {
        List<Order> list = orderService.findByCustomerAndDateAndStatus(customerId, fromDate, toDate, status);
        return MessageUtil.success("SUCCESS", list);
    }

    @ApiOperation(value = "通过员工ID + 起止日期 + 订单状态查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fromDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "toDate", value = "结束日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    })
    @GetMapping("find_by_employee_n_date_n_status")
    public Message findByEmployeeAndDateAndStatus(long employeeId, long fromDate, long toDate, String status) {
        List<Order> list = orderService.findByEmployeeAndDateAndStatus(employeeId, fromDate, toDate, status);
        return MessageUtil.success("SUCCESS", list);
    }


    @ApiOperation(value = "通过ID修改订单状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true, paramType = "query")
    })
    @GetMapping("edit_order_status")
    public Message editOrderStatus(long id, String status) {
        orderService.editOrderStatus(id, status);
        return MessageUtil.success("订单状态修改成功");
    }
}