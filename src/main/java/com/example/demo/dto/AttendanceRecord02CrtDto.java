package com.example.demo.dto;

import com.example.demo.model.AttendanceRecord02;
import lombok.Data;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/15 13:46
 */
@Data
public class AttendanceRecord02CrtDto {
    /**
     * 等待创建的model
     */
    List<AttendanceRecord02> list;
}
