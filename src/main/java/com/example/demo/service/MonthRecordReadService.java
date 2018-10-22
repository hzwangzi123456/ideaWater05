package com.example.demo.service;

import com.example.demo.dto.MonthRecordListDto;
import com.example.demo.model.MonthRecord;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 11:23
 */
public interface MonthRecordReadService {

    List<MonthRecord> getMonthRecordList(MonthRecordListDto dto);
}
