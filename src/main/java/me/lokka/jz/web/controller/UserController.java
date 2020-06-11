package me.lokka.jz.web.controller;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("find_all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("find_all_with_role")
    public List<UserExtend> findAllWithRole() {
        return userService.findAllWithRole();
    }

    @GetMapping("del_by_id")
    public String delById(long id) {
        userService.delById(id);
        return "SUCCESS";
    }

    @PostMapping("save_or_edit")
    public String saveOrUpdate(User user) {
        userService.saveOrEdit(user);
        return "SUCCESS";
    }
}
