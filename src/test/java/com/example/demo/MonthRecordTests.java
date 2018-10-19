package com.example.demo;

import com.example.demo.dao.BaseDao;
import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.model.MonthRecord;
import com.example.demo.service.AttendanceRecord02ReadService;
import com.example.demo.service.Impl.MonthRecordWriteServiceImpl;
import com.example.demo.service.MonthRecordWriteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wangzi
 * @Date: 2018/10/19 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AttendanceRecord02Tests.class)
@ComponentScan(basePackages = {"com.example.demo"})
@MapperScan(basePackages = {"classpath*:/mapper/*.xml"})
public class MonthRecordTests extends BaseTest {

    @Autowired
    private MonthRecordWriteService monthRecordWriteService;

    @Autowired
    private AttendanceRecord02ReadService attendanceRecord02ReadService;

    @Test
    public void getAttendanceRecord02ListTest() {
        AttendanceRecord02ListDto attendanceRecord02ListDto = new AttendanceRecord02ListDto();
        attendanceRecord02ListDto.setWorkNumber(1);
        List<AttendanceRecord02> attendanceRecord02List = attendanceRecord02ReadService.getAttendanceRecord02List(attendanceRecord02ListDto);

        if (attendanceRecord02List == null) {
            System.out.println("查询为空");
            return;
        }

        for (AttendanceRecord02 a : attendanceRecord02List) {
            System.out.println(a);
        }
    }
}
