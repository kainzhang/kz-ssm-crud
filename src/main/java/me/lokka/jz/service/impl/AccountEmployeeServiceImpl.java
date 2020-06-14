package me.lokka.jz.service.impl;

import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.bean.AccountEmployeeExample;
import me.lokka.jz.dao.AccountEmployeeMapper;
import me.lokka.jz.service.IAccountEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountEmployeeServiceImpl implements IAccountEmployeeService {
    @Resource
    private AccountEmployeeMapper accountEmployeeMapper;

    @Override
    public void insert(AccountEmployee accountEmployee){
        accountEmployeeMapper.insert(accountEmployee);
    }

    @Override
    public List<AccountEmployee> findAll() {
        return accountEmployeeMapper.selectByExample(new AccountEmployeeExample());
    }

    @Override
    public List<AccountEmployee> findAllByUserId(long userId) {
        AccountEmployeeExample example = new AccountEmployeeExample();
        AccountEmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return accountEmployeeMapper.selectByExample(example);
    }

}