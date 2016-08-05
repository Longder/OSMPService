package com.microdata.osmpservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Longder on 2016/8/1.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/test1")
    public String test1() {
        System.out.println("进入控制器！");
        return "ok";
    }
}
