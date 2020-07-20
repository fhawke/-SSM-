package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/**
 * 价格档案实体类
 */
@Component
public class Price {
    private Long id;                     //序号
    private int value;                  //编号
    private String name;                //名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
