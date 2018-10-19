package com.example.demo.model;

import com.example.demo.enums.IselapunchType;
import lombok.Data;

@Data
public class MonthRecord {
    /**
     * 月记录id
     */
    private Integer id;

    /**
     * 年月
     */
    private String yearMonth;

    /**
     * 应到考勤
     */
    private Integer shouldAttendance;

    /**
     * 实到考勤
     */
    private Integer actualAttendacne;

    /**
     * 工号
     */
    private Integer workNumber;

    /**
     * 工作地点
     */
    private String workAddress;

    /**
     * 是否弹性打卡{@link IselapunchType}
     */
    private Integer iselapunch;

    /**
     * 外勤天数
     */
    private Integer workOutside;

    /**
     * 出差天数
     */
    private Integer businessTrip;

    /**
     * 事假天数
     */
    private Integer casualLeave;

    /**
     * 调休使用天数
     */
    private Integer daysOff;

    /**
     * 病假天数
     */
    private Integer sickLeave;

    /**
     * 年假使用天数
     */
    private Integer annualLeave;

    /**
     * 加班次数
     */
    private Integer overtimeNum;

    /**
     * 迟到早退次数
     */
    private Integer lateEarlyNum;

    /**
     * 迟到早退小时数
     */
    private Integer lateEarlyHours;

    /**
     * 忘记打卡次数
     */
    private Integer forgetPunchNum;

}