package me.lokka.jz.service.impl;

import me.lokka.jz.bean.AccountCustomer;
import me.lokka.jz.bean.AccountCustomerExample;
import me.lokka.jz.dao.AccountCustomerMapper;
import me.lokka.jz.service.IAccountCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountCustomerServiceImpl implements IAccountCustomerService {
    @Resource
    private AccountCustomerMapper accountCustomerMapper;

    @Override
    public void insert(AccountCustomer accountCustomer){
        accountCustomerMapper.insert(accountCustomer);
    }

    @Override
    public List<AccountCustomer> findAll() {
        return accountCustomerMapper.selectByExample((new AccountCustomerExample()));
    }

    @Override
    public List<AccountCustomer> findAllByUserId(long userId) {
        AccountCustomerExample example = new AccountCustomerExample();
        AccountCustomerExample.Criteria  criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return accountCustomerMapper.selectByExample(example);
    }

}