package com.microdata.osmpservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.microdata.osmpservice.dao.UserDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.po.User;
import com.microdata.osmpservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/8/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private PMSResult pmsResult;
    @Resource
    private UserDao userDao;

    /**
     * 用户登录校验
     *
     * @param userInfo json字符串
     * @return
     */
    public PMSResult loginCheck(String userInfo) {
        if (userInfo == null || "".equals(userInfo)) {
            pmsResult.setStatus(3);
            pmsResult.setMessage("信息发送有误");
            return pmsResult;
        }
        //把json字符串转成对象
        User loginUser = JSON.parseObject(userInfo, User.class);
        System.out.println(loginUser.getUserId());
        User dbUser = userDao.findByUserId(loginUser.getUserId());
        if (dbUser == null) {
            pmsResult.setStatus(1);
            pmsResult.setMessage("用户名不存在");
        } else if (!loginUser.getPassword().equals(dbUser.getPassword())) {
            pmsResult.setStatus(2);
            pmsResult.setMessage("密码错误");
        } else {
            pmsResult.setStatus(0);
            pmsResult.setMessage("登陆成功");
            pmsResult.setData(dbUser);
        }
        return pmsResult;
    }
}
