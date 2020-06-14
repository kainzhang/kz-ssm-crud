package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.service.IAccountEmployeeService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AccountEmployeeController
 * @Description
 * @Author lenovo
 * @Date 2020/6/14 16:44
 **/

@Api(description = "员工账户管理接口")
@RestController
@RequestMapping("/accountEmployee")
public class AccountEmployeeController {
    @Autowired
    private IAccountEmployeeService accountEmployeeService;

    @ApiOperation(value = "提交操作申请")
    @PostMapping("save")
    public Message save(AccountEmployee accountEmployee){
        accountEmployeeService.insert(accountEmployee);
        return MessageUtil.success("SUCCESS");
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll(){
        List<AccountEmployee> list=accountEmployeeService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过用户Id查询操作记录")
    @ApiImplicitParam(name = "userId", value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_user_id")
    public Message selectAllByUserId(long userId){
        List< AccountEmployee> list= accountEmployeeService.findAllByUserId(userId);
        return MessageUtil.success(list);
    }

}