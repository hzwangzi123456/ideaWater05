package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:21
 */
@Data
public class AttendanceRecord02ListDto {
    /**
     * 工号
     */
    private Integer workNumber;

    /**
     * 查询开始时间
     */
    private String searchStartDate;

    /**
     * 查询结束时间
     */
    private String searchEndDate;

    /**
     * 查询年月
     */
    private String searchYearMonth;
}
