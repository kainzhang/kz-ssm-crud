package me.lokka.jz.service.impl;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.UserExample;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.dao.UserMapper;
import me.lokka.jz.dao.extend.UserExtendMapper;
import me.lokka.jz.service.IUserService;
import me.lokka.jz.utils.CustomerException;
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
    public List<UserExtend> findAllEmployee() {
        // Employee : roleId = 3
        return userExtendMapper.selectByRole(3);
    }

    /**
     * @param id
     * @return
     * @Descr 通过 用户ID 查询详情
     */
    @Override
    public UserExtend findById(long id) {
        return userExtendMapper.selectById(id);
    }

    @Override
    public void saveOrEdit(User user) throws CustomerException {
        if (user.getId()== null) {
            userMapper.insert(user);
        }else{
            User userT = userMapper.selectByPrimaryKey(user.getId());
            if(userT == null){
                throw new CustomerException("修改失败，数据不存在");
            }
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void delById(long id) {
        if(userMapper.selectByPrimaryKey(id)== null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param id
     * @param avatar
     * @throws CustomerException
     * @Descr 通过 用户ID 修改 用户头像
     */
    @Override
    public void editAvatarById(long id, String avatar) throws CustomerException {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomerException("修改失败，用户不存在");
        }
        user.setUserFace(avatar);
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * @param id
     * @param status
     * @throws CustomerException
     * @Descr 通过 用户ID 修改 用户状态
     */
    @Override
    public void editStatusById(long id, String status) throws CustomerException {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomerException("修改失败，用户不存在");
        }
        user.setStatus(status);
        userMapper.updateByPrimaryKey(user);
    }


}
