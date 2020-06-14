package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.service.IUserService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
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
    public Message findAll() {
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取全部+角色信息")
    @GetMapping("find_all_with_role")
    public Message findAllWithRole() {
        List<UserExtend> list = userService.findAllWithRole();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @ApiImplicitParam(name = "id" ,value = "用户唯一编号（添加新用户时不填）", paramType = "query")
    @PostMapping("save_or_edit")
    public Message saveOrUpdate(User user) {
        userService.saveOrEdit(user);
        return MessageUtil.success("SUCCESS");
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id" ,value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        userService.delById(id);
        return MessageUtil.success("SUCCESS");
    }

    @ApiOperation(value = "通过ID查找")
    @ApiImplicitParam(name = "id" ,value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        UserExtend userExtend = userService.findById(id);
        return MessageUtil.success(userExtend);
    }

    @ApiOperation(value = "通过ID修改用户状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "用户唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status" ,value = "用户状态", required = true, paramType = "query")
    })
    @PostMapping("edit_status")
    public Message editStatus(long id, String status) {
        userService.editStatusById(id, status);
        return MessageUtil.success("修改成功");
    }

    @ApiOperation(value = "通过ID修改头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "用户唯一编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "avatar" ,value = "头像文件", required = true, paramType = "query")
    })
    @PostMapping("edit_avatar")
    public Message editAvatar(long id, String avatar) {
        userService.editAvatarById(id, avatar);
        return MessageUtil.success("修改成功");
    }

}
