package com.example.demo.service;

import com.example.demo.dto.AttendanceRecord02CrtDto;
import com.example.demo.dto.MonthRecordCrtDto;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 11:30
 */
public interface MonthRecordWriteService {

    /**
     * 创建月考勤记录
     * @param dto 等待创建月考勤记录的dto
     * @return true表示成功，false表示失败
     */
    boolean monthRecordCreate(MonthRecordCrtDto dto);
}
