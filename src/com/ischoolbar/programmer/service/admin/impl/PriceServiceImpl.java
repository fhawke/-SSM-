package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.PriceDao;
import com.ischoolbar.programmer.entity.admin.Price;
import com.ischoolbar.programmer.service.admin.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 价格档案Service实现类
 */
@Service
public class PriceServiceImpl implements PriceService{
    @Autowired
    private PriceDao priceDao;
    @Override
    public int add(Price price) {
        return priceDao.add(price);
    }

    @Override
    public int edit(Price price) {
        return priceDao.edit(price);
    }

    @Override
    public List<Price> findList(Map<String, Object> queryMap) {
        return priceDao.findList(queryMap);
    }

    @Override
    public int delete(Long id) {
        return priceDao.delete(id);
    }


    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return priceDao.getTotal(queryMap);
    }

    @Override
    public List<Price> GetList() {
        return priceDao.GetList();
    }

}
