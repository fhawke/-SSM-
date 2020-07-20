package com.ischoolbar.programmer.service.admin;

import com.ischoolbar.programmer.entity.admin.Price;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 价格档案Service类
 */
@Service
public interface PriceService {
    public int add(Price price);
    public int edit(Price price);
    public List<Price> findList(Map<String,Object> queryMap);
    public int delete(Long id);
    public Integer getTotal(Map<String,Object> queryMap);
    public List<Price> GetList();
}
