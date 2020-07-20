package com.ischoolbar.programmer.controller.admin;
import org.springframework.ui.Model;
import com.ischoolbar.programmer.entity.admin.Account;
import com.ischoolbar.programmer.entity.admin.Price;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.AccountService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 结算方式管理后台控制器
 */
@RequestMapping("/admin/account")
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 结算方式列表页面
     * @param model
     * @return
     */

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model)
    {
        model.addObject("cus",accountService.GetList());
        model.setViewName("account/list");
        return model;
    }



    /**
     * 结算方式添加
     * @param account
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Account account){
        Map<String,String> ret = new HashMap<String,String>();
        if(account == null){
            ret.put("type","error");
            ret.put("msg","请填写正确的价格档案信息!");
            return ret;
        }
        if(StringUtils.isEmpty(account.getName())){
            ret.put("type","error");
            ret.put("msg","请填写价格名称!");
            return ret;
        }
        if(accountService.add(account) <= 0){
            ret.put("type","error");
            ret.put("msg","添加失败，请联系管理员!");
            return ret;
        }
        System.out.println("add success!");
        ret.put("type","success");
        ret.put("msg","添加成功!");
        return ret;

    }

    /**
     * 编辑结算方式
     * @param account
     * @return
     */
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(Account account){
        //System.out.println(" get in edit ");
        Map<String,String> ret = new HashMap<String,String>();
        if(account == null){
            //System.out.println("first one");
            ret.put("type","error");
            ret.put("msg","请填写正确的结算方式信息!");
            return ret;
        }
        if(StringUtils.isEmpty(account.getName())){
            //System.out.println("two");
            ret.put("type","error");
            ret.put("msg","请填写结算方式名称!");
            return ret;
        }
        if(accountService.edit(account) <= 0){
            //System.out.println("three");
            ret.put("type","error");
            ret.put("msg","编辑失败，请联系管理员!");
            return ret;
        }
        System.out.println("break？");
        ret.put("type","success");
        ret.put("msg","编辑成功!");
        return ret;

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
        ret.put("rows",accountService.findList(queryMap));
        ret.put("total",accountService.getTotal(queryMap));
        return ret;
    }



}
