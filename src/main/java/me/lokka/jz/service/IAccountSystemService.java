package me.lokka.jz.service;
import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.bean.AccountSystem;


import java.util.List;

public interface IAccountSystemService {

    void insert(AccountSystem accountSystem);

    List<AccountSystem> findAll();

    List<AccountSystem> findAllByUserId(long userId);

}