package com.ischoolbar.programmer.controller.admin;

import com.ischoolbar.programmer.entity.admin.Price;
import com.ischoolbar.programmer.entity.admin.Rate;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.RateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 利率档案控制层
 */
@RequestMapping("/admin/rate")
@Controller
public class RateController {
    @Autowired
    private RateService rateService;

    /**
     * 利率档案列表页面
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
        model.addObject("cus",rateService.GetList());
        model.setViewName("rate/list");
        return model;
    }

    /**
     * 模糊搜索分页显示列表查询
     * @param name
     * @param page
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> list(
            @RequestParam(name="name",defaultValue="") String name,
            Page page
    ){
        Map<String,Object> ret = new HashMap<String,Object>();
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name",name);
        queryMap.put("offset",page.getOffset());
        queryMap.put("pageSize",page.getRows());
        ret.put("rows",rateService.findList(queryMap));
        ret.put("total",rateService.getTotal(queryMap));
        return ret;
    }

    /**
     * 添加利率档案
     * @param rate
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Rate rate){
        Map<String,String> ret = new HashMap<String,String>();
        if(rate == null){
            ret.put("type","error");
            ret.put("msg","请填写正确的价格档案信息!");
            return ret;
        }
        if(StringUtils.isEmpty(rate.getName())){
            ret.put("type","error");
            ret.put("msg","请填写价格名称!");
            return ret;
        }
        if(rateService.add(rate) <= 0){
            ret.put("type","error");
            ret.put("msg","添加失败，请联系管理员!");
            return ret;
        }
        ret.put("type","success");
        ret.put("msg","添加成功!");
        return ret;

    }

    /**
     * 编辑利率档案
     * @param rate
     * @return
     */
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(Rate rate){
        Map<String,String> ret = new HashMap<String,String>();
        if(rate == null){
            ret.put("type","error");
            ret.put("msg","请填写正确的价格档案信息!");
            return ret;
        }
        if(StringUtils.isEmpty(rate.getName())){
            ret.put("type","error");
            ret.put("msg","请填写价格名称!");
            return ret;
        }
        if(rateService.edit(rate) <= 0){
            ret.put("type","error");
            ret.put("msg","编辑失败，请联系管理员!");
            return ret;
        }
        ret.put("type","success");
        ret.put("msg","编辑成功!");
        return ret;

    }
}
