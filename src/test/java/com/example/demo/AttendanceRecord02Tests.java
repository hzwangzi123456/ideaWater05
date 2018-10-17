package com.example.demo;

import com.example.demo.dto.AttendanceRecord02CrtDto;
import com.example.demo.dto.AttendanceRecord02ListDto;
import com.example.demo.enums.Attendance01Type;
import com.example.demo.model.AttendanceRecord02;
import com.example.demo.service.AttendanceRecord02ReadService;
import com.example.demo.service.AttendanceRecord02WriteService;
import com.example.demo.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.example.demo.utils.DateUtil.getDateFromStr;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AttendanceRecord02Tests.class)
@ComponentScan(basePackages = {"com.example.demo"})
@MapperScan(basePackages = {"classpath*:/mapper/*.xml"})
public class AttendanceRecord02Tests extends BaseTest {

    @Autowired
    AttendanceRecord02ReadService attendanceRecord02ReadService;

    @Autowired
    AttendanceRecord02WriteService attendanceRecord02WriteService;

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
    public void createAttendanceRecord02Test() {
        AttendanceRecord02CrtDto attendanceRecord02CrtDto = new AttendanceRecord02CrtDto();

        List<AttendanceRecord02> attendanceRecord02s = new ArrayList<>();

        String startDate = "2016-01-01 00:00:00";
        for (int i = 0; i < 800; i++) {
            if(isWorkEnd(startDate)) {
                //后一天
                startDate = DateUtil.getDiffMinuteDateStr02(startDate, (int) (60 * 24));
                continue;
            }
            AttendanceRecord02 a1 = new AttendanceRecord02();
            a1.setWorkNumber(4);
            a1.setType(Attendance01Type.NORMAL.value());
            a1.setStartPosition("浙江农林大学");
            a1.setEndPosition("浙江农林大学");
            a1.setStartTime(createStartTime(startDate));
            a1.setEndTime(createEndTime(startDate));
            a1.setHours(Double.valueOf(String.format("%.2f", daysBetween(a1.getStartTime(),a1.getEndTime()))));

            startDate = DateUtil.getDiffMinuteDateStr02(startDate, (int) (60 * 24));
            attendanceRecord02s.add(a1);
        }

        attendanceRecord02CrtDto.setList(attendanceRecord02s);
        boolean b = attendanceRecord02WriteService.attendanceRecord02Create(attendanceRecord02CrtDto);
        System.out.println("创建结果：" + b);
    }


    /**
     * 去掉时间，创建自己的开始时间
     *
     * @param str
     */
    private static String createStartTime(String str) {
        String substring = str.substring(0, 11);
        substring += "08:";
        int mintemp = (int) (Math.random() * 59);
        if (mintemp < 10) {
            substring += "0";
            substring += mintemp;
        } else {
            substring += mintemp;
        }
        substring += ":";
        int secTemp = (int) (Math.random() * 59);
        if (secTemp < 10) {
            substring += "0";
            substring += secTemp;
        } else {
            substring += secTemp;
        }
        return substring;
    }

    /**
     * 去掉时间，创建自己的结束时间
     *
     * @param str
     * @return
     */
    private static String createEndTime(String str) {
        String substring = str.substring(0, 11);
        substring += "18:";
        int mintemp = (int) (Math.random() * 59);
        if (mintemp < 10) {
            substring += "0";
            substring += mintemp;
        } else {
            substring += mintemp;
        }
        substring += ":";
        int secTemp = (int) (Math.random() * 59);
        if (secTemp < 10) {
            substring += "0";
            substring += secTemp;
        } else {
            substring += secTemp;
        }
        return substring;
    }

    /**
     * 该日期是工作日
     * @param a
     * @return
     */
    private static boolean isWorkDay(String a) {
        Date d1 = getDateFromStr("yyyy-MM-dd HH:mm:ss", a);
        Calendar now1 = Calendar.getInstance();
        now1.setTime(d1);
        int i = now1.get(now1.DAY_OF_WEEK)-1;
        if(i == 0 || i == 6) {
            return false;
        }
        return true;
    }

    /**
     * 该日期是周末
     * @param a
     * @return
     */
    private static boolean isWorkEnd(String a) {
        return !isWorkDay(a);
    }
    /**
     * 比较两个日期之间相差小时
     * @param a
     * @param b
     * @return
     */
    private static double daysBetween(String a, String b) {
        Date d1 = getDateFromStr("yyyy-MM-dd HH:mm:ss", a);
        Calendar now1 = Calendar.getInstance();
        now1.setTime(d1);
        long l1 = now1.getTimeInMillis();

        now1.setTime(getDateFromStr("yyyy-MM-dd HH:mm:ss", b));
        long l2 = now1.getTimeInMillis();

        double hour = (l2 - l1) * 1.0 / 1000 / 60 / 60;
        return hour;
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            String startTime = createStartTime("2018-12-25 10:09:10");
            System.out.println(startTime);
        }
    }
}
