package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Privilege;
import me.lokka.jz.bean.PrivilegeExample;
import me.lokka.jz.bean.extend.PrivilegeExtend;
import me.lokka.jz.dao.PrivilegeMapper;
import me.lokka.jz.dao.extend.PrivilegeExtendMapper;
import me.lokka.jz.service.IPrivilegeService;
import me.lokka.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;
    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;


    @Override
    public List<Privilege> findAll() {
        return privilegeMapper.selectByExample(new PrivilegeExample());
    }

    @Override
    public List<PrivilegeExtend> findAllWithChild() {
        return privilegeExtendMapper.selectAllWithChild();
    }

    @Override
    public Privilege findById(long id) {
        return privilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(Privilege privilege) throws CustomerException {
        if (privilege.getId() == null) {
            privilegeMapper.insert(privilege);
        } else {
            Privilege privilege1 = privilegeMapper.selectByPrimaryKey(privilege.getId());
            if (privilege1 == null) {
                throw new CustomerException("修改失败，数据不存在");
            }
            privilegeMapper.updateByPrimaryKey(privilege);
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        Privilege privilege = privilegeMapper.selectByPrimaryKey(id);
        if (privilege == null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        privilegeMapper.deleteByPrimaryKey(id);
    }
}