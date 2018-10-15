package com.example.demo.service;

import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.model.AttendanceRecord02;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:10
 */
public interface AttendanceRecord02ReadService {
    List<AttendanceRecord02> getAttendanceRecord02List(AttendanceRecord02ListDto attendanceRecord02ListDto);
}
