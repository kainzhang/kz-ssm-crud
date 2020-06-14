package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.AccountCustomer;
import me.lokka.jz.service.IAccountCustomerService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "客户账户管理接口")
@RestController
@RequestMapping("/accountCustomer")
public class AccountCustomerController {
    @Autowired
    private IAccountCustomerService accountCustomerService;

    @ApiOperation(value = "提交审核")
    @PostMapping("save")
    public Message save(AccountCustomer accountCustomer){
        accountCustomerService.insert(accountCustomer);
        return MessageUtil.success("SUCCESS");
    }

    @ApiOperation(value = "通过UserId查询操作记录")
    @ApiImplicitParam(name = "userId", value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_user_id")
    public Message selectAllByUserId(long userId){
        List<AccountCustomer> list = accountCustomerService.findAllByUserId(userId);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll(){
        List<AccountCustomer> list = accountCustomerService.findAll();
        return MessageUtil.success(list);
    }

}