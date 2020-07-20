package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/**
 * 结算方式实体类
 */
@Component
public class Account {
    private Long id;        //序号
    private int num;        //编号
    private String name;    //全名
    private String remark;  //备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
