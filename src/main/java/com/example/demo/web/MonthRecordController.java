package com.example.demo.web;

import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.dto.MonthRecordListDto;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.model.MonthRecord;
import com.example.demo.service.MonthRecordReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/22 15:01
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/MonthRecordController")
@Slf4j
public class MonthRecordController {
    protected final static String CHARSET = ";charset=UTF-8";

    @Autowired
    private MonthRecordReadService monthRecordReadService;

    @RequestMapping(value = "/getMonthRecordList", produces = MediaType.APPLICATION_JSON_VALUE + CHARSET)
    public List<MonthRecord> getMonthRecordList(MonthRecordListDto monthRecordListDto) {
        log.info("[MonthRecordController] receive getMonthRecordList request.");
        List<MonthRecord> monthRecordList = monthRecordReadService.getMonthRecordList(monthRecordListDto);
        log.info("[MonthRecordController] finish getMonthRecordList request.");
        return monthRecordList;
    }
}
