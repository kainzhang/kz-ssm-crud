package me.lokka.jz.service;

import me.lokka.jz.bean.User;
import me.lokka.jz.bean.extend.UserExtend;
import me.lokka.jz.utils.CustomerException;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    List<UserExtend> findAllWithRole();

    /**
     * @Descr 通过 用户ID 查询详情
     *
     * @param id
     * @return
     */
    UserExtend findById(long id);

    void saveOrEdit(User user);

    void delById(long id) throws CustomerException;

    /**
     * @Descr 通过 用户ID 修改 用户头像
     *
     * @param id
     * @param avatar
     * @throws CustomerException
     */
    void editAvatarById(long id, String avatar) throws CustomerException;

    /**
     * @Descr 通过 用户ID 修改 用户状态
     *
     * @param id
     * @param status
     * @throws CustomerException
     */
    void editStatusById(long id, String status) throws CustomerException;

}
