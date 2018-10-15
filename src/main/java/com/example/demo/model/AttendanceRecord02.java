package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 14:40
 */
@Data
public class AttendanceRecord02 {
    /**
     * 打卡记录id
     */
    private Integer id;

    /**
     * 工号
     */
    private Integer workNumber;

    /**
     * 打卡类型
     */
    private Integer type;

    /**
     * 上班打卡时间
     */
    private String startTime;

    /**
     * 下班打卡时间
     */
    private String endTime;

    /**
     * 上班时间
     */
    private Double hours;

    /**
     * 上班打卡地点
     */
    private String startPosition;

    /**
     * 下班打卡地点
     */
    private String endPosition;
}
