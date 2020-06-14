package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Privilege;
import me.lokka.jz.bean.extend.PrivilegeExtend;

import java.util.List;

public interface PrivilegeExtendMapper {

    List<PrivilegeExtend> selectAllWithChild();

    List<Privilege> selectByParentId(long id);
}