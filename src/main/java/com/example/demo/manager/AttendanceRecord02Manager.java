package com.example.demo.manager;

import com.example.demo.dao.AttendanceRecord02Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:08
 */
@Component
public class AttendanceRecord02Manager {

    @Autowired(required = true)
    AttendanceRecord02Dao attendanceRecord02Dao;


}
