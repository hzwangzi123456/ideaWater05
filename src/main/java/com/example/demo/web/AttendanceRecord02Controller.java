package com.example.demo.web;

import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.service.AttendanceRecord02ReadService;
import com.example.demo.service.AttendanceRecord02WriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/15 17:32
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/AttendanceRecord02Controller")
@Slf4j
public class AttendanceRecord02Controller {
    protected final static String CHARSET = ";charset=UTF-8";

    @Autowired
    private AttendanceRecord02WriteService attendanceRecord02WriteService;

    @Autowired
    private AttendanceRecord02ReadService attendanceRecord02ReadService;

    @RequestMapping(value = "/getAttendanceRecord02List",produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public List<AttendanceRecord02> getAttendanceRecord02List(AttendanceRecord02ListDto dto) {
//      log.info("[AttendanceRecord02Controller] receive getAttendanceRecord02List request.");
        dto.setSearchEndDate(dto.getSearchYearMonth().trim() + "-31 23:59:59");
        dto.setSearchStartDate(dto.getSearchYearMonth().trim() + "-01 00:00:00");
        List<AttendanceRecord02> attendanceRecord02List = attendanceRecord02ReadService.getAttendanceRecord02List(dto);
//      log.info("[AttendanceRecord02Controller] finish getAttendanceRecord02List request.");
        return attendanceRecord02List;
    }

}
