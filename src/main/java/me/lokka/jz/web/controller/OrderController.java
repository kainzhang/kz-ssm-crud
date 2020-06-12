package me.lokka.jz.web.controller;

import io.swagger.annotations.ApiOperation;
import me.lokka.jz.service.IOrderService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import me.lokka.jz.vm.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("commit")
    @ApiOperation("提交订单")
    public Message commit(@RequestBody OrderVM orderVM){
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success("success",orderService.findAll());
    }

    @GetMapping("findById")
    public Message findById(long id){
        return MessageUtil.success("success",orderService.findOrderDetailsById(id));
    }
}