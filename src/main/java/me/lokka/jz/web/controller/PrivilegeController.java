package me.lokka.jz.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.Privilege;
import me.lokka.jz.bean.extend.PrivilegeExtend;
import me.lokka.jz.service.IPrivilegeService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "权限管理接口")
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    @Autowired
    private IPrivilegeService privilegeService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<Privilege> list = privilegeService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取嵌套结构")
    @GetMapping("find_all_with_child")
    public Message findAllWithChild() {
        List<PrivilegeExtend> list = privilegeService.findAllWithChild();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过ID查找")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        Privilege privilege = privilegeService.findById(id);
        return MessageUtil.success(privilege);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(Privilege privilege) {
        privilegeService.saveOrEdit(privilege);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        privilegeService.delById(id);
        return MessageUtil.success("删除成功");
    }

}