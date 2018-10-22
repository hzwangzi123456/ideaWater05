package com.example.demo.service.Impl;

import com.example.demo.dao.MonthRecordDao;
import com.example.demo.dto.MonthRecordListDto;
import com.example.demo.model.MonthRecord;
import com.example.demo.service.MonthRecordReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangzi
 * @Date: 2018/10/22 10:58
 */
@Slf4j
@Service
public class MonthRecordReadServiceImpl implements MonthRecordReadService {

    @Autowired
    private MonthRecordDao monthRecordDao;

    @Override
    public List<MonthRecord> getMonthRecordList(MonthRecordListDto dto) {
        log.info("[MonthRecordReadServiceImpl] getMonthRecordList request :{}", dto);
        Map<String, Object> map = new HashMap<>();
        map.put("workNumber", dto.getWorkNumber());
        List<MonthRecord> list = null;
        try {
            log.info("[MonthRecordReadServiceImpl] getMonthRecordList request monthRecordDao list before");
            list = monthRecordDao.list(map);
            log.info("[MonthRecordReadServiceImpl] getMonthRecordList request monthRecordDao list after");
            if (list == null || list.size() == 0) {
                log.info("[MonthRecordReadServiceImpl] getMonthRecordList 0");
                return null;
            }
            for (MonthRecord m : list) {
                System.out.println(m);
            }
        } catch (Exception e) {
            log.info("[MonthRecordReadServiceImpl] getMonthRecordList error");
        }

        log.info("[MonthRecordReadServiceImpl] getMonthRecordList finish");
        return list;
    }
}
