package me.lokka.jz.service.impl;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.UserExample;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.dao.UserMapper;
import me.lokka.jz.dao.extend.UserExtendMapper;
import me.lokka.jz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> findAllWithRole() {
        return userExtendMapper.selectAllWithRole();
    }

    @Override
    public void saveOrEdit(User user) {
        if (user.getId() == null) {
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void delById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
