package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.bean.AccountSystem;
import me.lokka.jz.service.IAccountSystemService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AccountSystemController
 * @Description TODO
 * @Author wangzhenxing
 * @Date 2020/6/14 15:13
 **/

@Api(description = "系统账户管理接口")
@RestController
@RequestMapping("/accountSystem")
public class AccountSystemController {
    @Autowired
    private IAccountSystemService accountSystemService;

    @ApiOperation(value = "提交操作申请")
    @PostMapping("save")
    public Message save(AccountSystem accountSystem ) {
        accountSystemService.insert(accountSystem);
        return MessageUtil.success("SUCCESS");
    }

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll(){
        List<AccountSystem> list = accountSystemService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过用户ID查询操作记录")
    @ApiImplicitParam(name = "userId", value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_user_id")
    public Message selectAllByUserId(long userId){
        List<AccountSystem> list = accountSystemService.findAllByUserId(userId);
        return MessageUtil.success(list);
    }

}