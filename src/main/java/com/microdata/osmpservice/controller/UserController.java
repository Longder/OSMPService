package com.microdata.osmpservice.controller;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Longder on 2016/8/8.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录校验
     *
     * @param userInfo {userId:"admin",password:"1234"}
     * @return
     */
    @RequestMapping(value = "/login")
    public PMSResult login(@RequestBody String userInfo) {
        //
        PMSResult pmsResult = userService.loginCheck(userInfo);
        return pmsResult;
    }
}
