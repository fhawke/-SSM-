package com.ischoolbar.programmer.service.admin;
/**
 * 结算方式Service类
 */

import com.ischoolbar.programmer.entity.admin.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AccountService {
    public int add(Account account);
    public int edit(Account account);
    public List<Account> findList(Map<String,Object> queryMap);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Account> GetList();

}
