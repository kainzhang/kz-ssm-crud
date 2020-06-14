package me.lokka.jz.service.impl;

import me.lokka.jz.bean.AccountSystem;
import me.lokka.jz.bean.AccountSystemExample;
import me.lokka.jz.dao.AccountSystemMapper;
import me.lokka.jz.service.IAccountSystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountSystemImpl
 * @Description TODO
 * @Author wangzhenxing
 * @Date 2020/6/14 15:43
 **/

@Service
public class AccountSystemServiceImpl implements IAccountSystemService {
    @Resource
    private AccountSystemMapper accountSystemMapper;

    @Override
    public void insert(AccountSystem accountSystem) {
        accountSystemMapper.insert(accountSystem);
    }

    @Override
    public List<AccountSystem> findAll() {
        return accountSystemMapper.selectByExample(new AccountSystemExample());
    }

    @Override
    public List<AccountSystem> findAllByUserId(long userId) {
        AccountSystemExample example = new AccountSystemExample();
        AccountSystemExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return accountSystemMapper.selectByExample(example);
    }

}