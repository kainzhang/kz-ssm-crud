package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.extend.UserExtend;

import java.util.List;

public interface UserExtendMapper {

    List<UserExtend> selectAllWithRole();

    List<UserExtend> selectByRole(long roleId);

    UserExtend selectById(long id);

}
