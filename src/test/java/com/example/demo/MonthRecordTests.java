package com.example.demo;

import com.example.demo.dao.BaseDao;
import com.example.demo.dao.MonthRecordDao;
import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.dto.MonthRecordCrtDto;
import com.example.demo.enums.IselapunchType;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.model.MonthRecord;
import com.example.demo.service.AttendanceRecord02ReadService;
import com.example.demo.service.Impl.MonthRecordWriteServiceImpl;
import com.example.demo.service.MonthRecordReadService;
import com.example.demo.service.MonthRecordWriteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private MonthRecordReadService monthRecordReadService;
    @Autowired
    private MonthRecordDao monthRecordDao;

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

    @Test
    public void crtMonthRecordTest() {
        Map<String, List<AttendanceRecord02>> map = new HashMap<>();
        AttendanceRecord02ListDto attendanceRecord02ListDto = new AttendanceRecord02ListDto();
        attendanceRecord02ListDto.setWorkNumber(4);
        List<AttendanceRecord02> attendanceRecord02List = attendanceRecord02ReadService.getAttendanceRecord02List(attendanceRecord02ListDto);

        for (AttendanceRecord02 a : attendanceRecord02List) {
            String s = yearMonth(a.getStartTime());
            if (map.containsKey(s)) {
                List<AttendanceRecord02> attendanceRecord02s = map.get(s);
                attendanceRecord02s.add(a);
            } else {
                map.put(s, new ArrayList<AttendanceRecord02>());
                List<AttendanceRecord02> list = map.get(s);
                list.add(a);
            }
        }

        MonthRecordCrtDto monthRecordCrtDto = new MonthRecordCrtDto();
        monthRecordCrtDto.setList(new ArrayList<MonthRecord>());

        for (String str : map.keySet()) {
            int num = map.get(str).size();
            MonthRecord monthRecord = new MonthRecord();
            monthRecord.setYearMonth(str);
            monthRecord.setShouldAttendance(num);
            monthRecord.setActualAttendacne(num);
            monthRecord.setAnnualLeave(0);
            monthRecord.setBusinessTrip(0);
            monthRecord.setCasualLeave(0);
            monthRecord.setDaysOff(0);
            monthRecord.setForgetPunchNum(0);
            monthRecord.setIselapunch(IselapunchType.ISELAPUNCH.value());
            monthRecord.setLateEarlyHours(0);
            monthRecord.setOvertimeNum(0);
            monthRecord.setSickLeave(0);
            monthRecord.setWorkOutside(0);
            monthRecord.setWorkAddress("浙江农林大学");
            monthRecord.setWorkNumber(4);
            monthRecord.setLateEarlyNum(0);
            monthRecordCrtDto.getList().add(monthRecord);
        }

        boolean b = monthRecordWriteService.monthRecordCreate(monthRecordCrtDto);
        System.out.println(b);
    }

    private String yearMonth(String time) {
        return time.substring(0, 7);
    }

    @Test
    public void getMonthRecordListDao() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("workNumber", 4);
        List<MonthRecord> list = monthRecordDao.list(map);
        for (MonthRecord m : list) {
            System.out.println(m);
        }
    }
}
