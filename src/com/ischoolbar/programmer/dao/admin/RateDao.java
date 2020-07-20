package com.ischoolbar.programmer.dao.admin;

import com.ischoolbar.programmer.entity.admin.Rate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 利率档案Dao层
 */
@Repository
public interface RateDao {
    public int add(Rate rate);
    public int edit(Rate rate);
    public List<Rate> findList(Map<String,Object> queryMap);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Rate> GetList();
}
