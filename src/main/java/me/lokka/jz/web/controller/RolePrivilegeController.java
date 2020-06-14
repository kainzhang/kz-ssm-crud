package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.RolePrivilege;
import me.lokka.jz.bean.extend.RolePrivilegeExtend;
import me.lokka.jz.service.IRolePrivilegeService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "角色权限管理接口")
@RestController
@RequestMapping("/role_privilege")
public class RolePrivilegeController {
    @Autowired
    private IRolePrivilegeService rolePrivilegeService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<RolePrivilege> list = rolePrivilegeService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过ID查找")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        RolePrivilege rolePrivilege = rolePrivilegeService.findById(id);
        return MessageUtil.success(rolePrivilege);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(RolePrivilege rolePrivilege) {
        rolePrivilegeService.saveOrEdit(rolePrivilege);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "获取全部 + 角色信息 + 权限信息")
    @GetMapping("find_all_with_role_and_privilege")
    public Message findAllWithRoleAndPrivilege() {
        List<RolePrivilegeExtend> list = rolePrivilegeService.findAllWithRoleAndPrivilege();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        rolePrivilegeService.delById(id);
        return MessageUtil.success("删除成功");
    }

}