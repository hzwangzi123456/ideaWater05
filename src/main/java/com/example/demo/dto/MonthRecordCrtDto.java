package com.example.demo.dto;

import com.example.demo.model.MonthRecord;
import lombok.Data;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 11:32
 */
@Data
public class MonthRecordCrtDto {
    /**
     * 等待创建的models
     */
    List<MonthRecord> list;
}
