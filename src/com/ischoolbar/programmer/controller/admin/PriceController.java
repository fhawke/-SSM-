package com.ischoolbar.programmer.controller.admin;

import com.ischoolbar.programmer.entity.admin.Price;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.PriceService;
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
 *  价格档案管理后台控制器
 */
@RequestMapping("/admin/price")
@Controller
public class PriceController {
    @Autowired
    private PriceService priceService;

    /**
     * 价格档案列表页面
     * @param model
     * @return
     */

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
        model.addObject("cus",priceService.GetList());
        model.setViewName("price/list");
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
        ret.put("rows",priceService.findList(queryMap));
        ret.put("total",priceService.getTotal(queryMap));
        return ret;
    }


    /**
     * 添加价格档案
     * @param price
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Price price){
        Map<String,String> ret = new HashMap<String,String>();
        if(price == null){
            ret.put("type","error");
            ret.put("msg","请填写正确的价格档案信息!");
            return ret;
        }
        if(StringUtils.isEmpty(price.getName())){
            ret.put("type","error");
            ret.put("msg","请填写价格名称!");
            return ret;
        }
        if(priceService.add(price) <= 0){
            ret.put("type","error");
            ret.put("msg","添加失败，请联系管理员!");
            return ret;
        }
        ret.put("type","success");
        ret.put("msg","添加成功!");
        return ret;

    }

    /**
     * 编辑价格档案
     * @param price
     * @return
     */
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(Price price){
        Map<String,String> ret = new HashMap<String,String>();
        if(price == null){
            ret.put("type","error");
            ret.put("msg","请填写正确的价格档案信息!");
            return ret;
        }
        if(StringUtils.isEmpty(price.getName())){
            ret.put("type","error");
            ret.put("msg","请填写价格名称!");
            return ret;
        }
        if(priceService.edit(price) <= 0){
            ret.put("type","error");
            ret.put("msg","编辑失败，请联系管理员!");
            return ret;
        }
        ret.put("type","success");
        ret.put("msg","编辑成功!");
        return ret;

    }


    /**
     * 删除价格档案
     * @param id
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(Long id){
        Map<String,String> ret = new HashMap<String,String>();
        if(id == null){
            ret.put("type","error");
            ret.put("msg","请选择要删除的数据!");
            return ret;
        }

        if(priceService.delete(id) <= 0){
            ret.put("type","error");
            ret.put("msg","删除失败，请联系管理员!");
            return ret;
        }
        ret.put("type","success");
        ret.put("msg","删除成功!");
        return ret;
    }
}
