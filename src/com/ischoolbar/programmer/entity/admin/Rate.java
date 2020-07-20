package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

@Component
public class Rate {
    private int id;         //序号
    private int num;        //利率编号
    private String name;    //利率全名
    private int rate;       //利息率
    private String remark;  //备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
