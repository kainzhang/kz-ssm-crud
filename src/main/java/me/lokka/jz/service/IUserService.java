package me.lokka.jz.service;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    List<UserExtend> findAllWithRole();

    void saveOrEdit(User user);

    void delById(long id);
}
