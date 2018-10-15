package com.example.demo.enums;

/**
 * @Author: wangzi
 * @Date: 2018/10/15 14:09
 */
public enum Attendance01Type {
    NORMAL(1, "正常打卡"),
    LEAVE(2, "请假"),
    ABSENT(3, "旷工");

    private final Integer value;
    private final String desc;

    Attendance01Type(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer value() {
        return value;
    }
}
