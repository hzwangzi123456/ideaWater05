package com.example.demo.service.Impl;

import com.example.demo.dao.AttendanceRecord02Dao;
import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.service.AttendanceRecord02ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:27
 */
@Service
public class AttendanceRecord02ReadServiceImpl implements AttendanceRecord02ReadService {

    @Autowired(required = true)
    private AttendanceRecord02Dao attendanceRecord02Dao;

    @Override
    public List<AttendanceRecord02> getAttendanceRecord02List(AttendanceRecord02ListDto attendanceRecord02ListDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("workNumber", attendanceRecord02ListDto.getWorkNumber());
        map.put("searchStartDate", attendanceRecord02ListDto.getSearchStartDate());
        map.put("searchEndDate", attendanceRecord02ListDto.getSearchEndDate());

        return attendanceRecord02Dao.list(map);
    }
}
