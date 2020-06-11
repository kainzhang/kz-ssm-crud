package me.lokka.jz.service;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void saveOrEdit(User user);

    void delById(long id);

    List<UserExtend> findAllWithRole();
}
