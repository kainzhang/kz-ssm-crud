package me.lokka.jz.service.impl;


import me.lokka.jz.bean.RolePrivilege;
import me.lokka.jz.bean.RolePrivilegeExample;
import me.lokka.jz.dao.RolePrivilegeMapper;
import me.lokka.jz.service.IRolePrivilegeService;
import me.lokka.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePrivilegeImpl implements IRolePrivilegeService {
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public List<RolePrivilege> findAll() {
        return rolePrivilegeMapper.selectByExample(new RolePrivilegeExample());
    }

    @Override
    public RolePrivilege findById(long id) {
        return rolePrivilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(RolePrivilege rolePrivilege) throws CustomerException {
        if(rolePrivilege.getId()==null){
            rolePrivilegeMapper.insert(rolePrivilege);
        }else{
            if(rolePrivilegeMapper.selectByPrimaryKey(rolePrivilege.getId())==null){
                throw new CustomerException("修改失败，数据不存在");
            }
            rolePrivilegeMapper.updateByPrimaryKey(rolePrivilege);
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        if(rolePrivilegeMapper.selectByPrimaryKey(id)==null){
            throw new CustomerException("删除失败，数据不存在");
        }
        rolePrivilegeMapper.deleteByPrimaryKey(id);
    }
}