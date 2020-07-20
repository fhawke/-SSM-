package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.AccountDao;
import com.ischoolbar.programmer.entity.admin.Account;
import com.ischoolbar.programmer.service.admin.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 结算方式Service实现类
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int edit(Account account) {
        return accountDao.edit(account);
    }

    @Override
    public List<Account> findList(Map<String, Object> queryMap) {
        return accountDao.findList(queryMap);
    }


    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return accountDao.getTotal(queryMap);
    }

    @Override
    public List<Account> GetList() {
        List<Account>  accounts = accountDao.GetList();
        return accounts;
    }




}
