package com.example.demo.service.Impl;

import com.example.demo.dao.MonthRecordDao;
import com.example.demo.dto.MonthRecordCrtDto;
import com.example.demo.model.MonthRecord;
import com.example.demo.service.MonthRecordWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 13:47
 */
@Service
@Slf4j
public class MonthRecordWriteServiceImpl implements MonthRecordWriteService {

    @Autowired
    private MonthRecordDao monthRecordDao;

    @Override
    public boolean monthRecordCreate(MonthRecordCrtDto dto) {
        log.info("[MonthRecordWriteServiceImpl] monthRecordCreate create request.list:{}", dto.getList());
        List<MonthRecord> list = dto.getList();
        int creates = monthRecordDao.creates(list);
        if (creates == list.size()) {
            log.info("[MonthRecordWriteServiceImpl] monthRecordCreate finish request.");
            return true;
        } else {
            log.info("[MonthRecordWriteServiceImpl] monthRecordCreate finish request.");
            return false;
        }
    }
}
