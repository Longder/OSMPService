package com.microdata.osmpservice.controller;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.po.User;
import com.microdata.osmpservice.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * @return
     */
    @RequestMapping(value = "/login")
    public PMSResult login(User loginUser) {
        return userService.loginCheck(loginUser);
    }
}
