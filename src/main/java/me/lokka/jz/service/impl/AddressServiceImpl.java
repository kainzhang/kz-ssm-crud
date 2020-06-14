package me.lokka.jz.service.impl;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.AddressExample;
import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.dao.AddressMapper;
import me.lokka.jz.dao.extend.AddressExtendMapper;
import me.lokka.jz.service.IAddressService;
import me.lokka.jz.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Class: AddressServiceImpl
 * @Descr: 地址业务实现类
 * @Author: LOKKA
 * @Date: 2020/6/14 9:55
 **/

@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AddressExtendMapper addressExtendMapper;

    @Override
    public List<Address> findAll() {
        return addressMapper.selectByExample(new AddressExample());
    }

    @Override
    public List<AddressExtend> findAllWithUser() {
        return addressExtendMapper.selectAllWithUser();
    }

    @Override
    public List<Address> findByUserId(long userId) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address findById(long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrEdit(Address address) throws CustomerException {
        if (address.getId() == null) {
            addressMapper.insert(address);
        } else {
            Address addressT = addressMapper.selectByPrimaryKey(address.getId());
            if (addressT == null) {
                throw new CustomerException("修改失败，数据不存在");
            } else {
                addressMapper.updateByPrimaryKey(address);
            }
        }
    }

    @Override
    public void delById(long id) throws CustomerException {
        Address address = addressMapper.selectByPrimaryKey(id);
        if (address == null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        addressMapper.deleteByPrimaryKey(id);
    }
}