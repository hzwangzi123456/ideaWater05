package com.example.demo.service;

import com.example.demo.dto.AttendanceRecord02CrtDto;
import com.example.demo.model.AttendanceRecord02;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:10
 */
public interface AttendanceRecord02WriteService {
    /**
     * 创建考勤记录
     * @param dto 考情记录创建dto
     * @return 创建是否成功
     */
    boolean attendanceRecord02Create(AttendanceRecord02CrtDto dto);

}
