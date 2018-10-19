package com.example.demo.enums;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 10:50
 */
public enum IselapunchType {
    ISELAPUNCH(1,"是弹性打卡"),
    NOTSELAPUNCH(0,"不是弹性打卡");

    private final Integer value;
    private final String desc;

    IselapunchType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer value() {
        return value;
    }
}
