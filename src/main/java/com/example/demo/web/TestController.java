package com.example.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 10:57
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/TestController")
@Slf4j
public class TestController {

    @RequestMapping(value = "/test")
    public String test() {
        return "hello!";
    }
}
