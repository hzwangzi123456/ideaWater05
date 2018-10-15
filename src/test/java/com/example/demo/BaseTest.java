package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 15:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("scratch")
@Rollback(false)
//@Transactional
public abstract class BaseTest {
}
