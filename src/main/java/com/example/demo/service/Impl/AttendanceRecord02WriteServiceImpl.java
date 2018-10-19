package com.example.demo.service.Impl;

import com.example.demo.dao.AttendanceRecord02Dao;
import com.example.demo.dto.AttendanceRecord02CrtDto;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.service.AttendanceRecord02WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/15 13:49
 */
@Service
public class AttendanceRecord02WriteServiceImpl implements AttendanceRecord02WriteService {
    @Autowired
    private AttendanceRecord02Dao attendanceRecord02Dao;

    @Override
    public boolean attendanceRecord02Create(AttendanceRecord02CrtDto dto) {
        List<AttendanceRecord02> list = dto.getList();

        int num = attendanceRecord02Dao.creates(list);
        if (num == list.size()) {
            return true;
        } else {
            return false;
        }
    }
}
