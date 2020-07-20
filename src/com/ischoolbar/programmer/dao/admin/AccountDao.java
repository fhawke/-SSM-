package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.Account;
import com.ischoolbar.programmer.entity.admin.Price;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 结算方式Dao层
 */
@Repository
public interface AccountDao {
    public int add(Account account);
    public int edit(Account account);
    public List<Account> findList(Map<String,Object> queryMap);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Account> GetList();

}
