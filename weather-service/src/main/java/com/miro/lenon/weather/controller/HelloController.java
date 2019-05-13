package com.miro.lenon.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mrio
 * @author: lu.yongmin
 * @create: 2019-05-13 22:20
 * @description:
 **/
@RestController
public class HelloController {

//    @RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
