package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @Author: wangzi
 * @Date: 2018/10/18 9:34
 */
@ControllerAdvice(basePackages = "com.example.demo.web")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {

        super("callback","jsonp");
    }
}
