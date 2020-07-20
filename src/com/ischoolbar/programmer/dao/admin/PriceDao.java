package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.Price;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Map;

/**
 * 价格档案Dao层
 */
@Repository
public interface PriceDao {
    public int add(Price price);
    public int edit(Price price);
    public List<Price> findList(Map<String,Object> queryMap);
    public int delete(Long id);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Price> GetList();
}
