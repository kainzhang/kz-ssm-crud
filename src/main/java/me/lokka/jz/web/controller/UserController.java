package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "用户管理接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "获取全部+角色信息")
    @GetMapping("find_all_with_role")
    public List<UserExtend> findAllWithRole() {
        return userService.findAllWithRole();
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public String saveOrUpdate(User user) {
        userService.saveOrEdit(user);
        return "SUCCESS";
    }

    @ApiOperation(value = "通过ID删除")
    @GetMapping("del_by_id")
    public String delById(long id) {
        userService.delById(id);
        return "SUCCESS";
    }
}
