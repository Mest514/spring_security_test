package com.mest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_security
 * @description:
 * @author: Mest
 * @create: 2022-12-15 20:19
 **/
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "hello spring_security_test";
    }

}
