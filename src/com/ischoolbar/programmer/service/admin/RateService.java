package com.ischoolbar.programmer.service.admin;

import com.ischoolbar.programmer.entity.admin.Rate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 利率档案Service层
 */
@Service
public interface RateService {
    public int add(Rate rate);
    public int edit(Rate rate);
    public List<Rate> findList(Map<String,Object> queryMap);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Rate> GetList();
}
