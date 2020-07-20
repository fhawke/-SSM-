package com.ischoolbar.programmer.service.admin.impl;

import com.ischoolbar.programmer.dao.admin.RateDao;
import com.ischoolbar.programmer.entity.admin.Rate;
import com.ischoolbar.programmer.service.admin.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateDao rateDao;

    @Override
    public int add(Rate rate) {
        return rateDao.add(rate);
    }

    @Override
    public int edit(Rate rate) {
        return rateDao.edit(rate);
    }

    @Override
    public List<Rate> findList(Map<String, Object> queryMap) {
        return rateDao.findList(queryMap);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        return rateDao.getTotal(queryMap);
    }

    @Override
    public List<Rate> GetList() {
        return rateDao.GetList();
    }


}
