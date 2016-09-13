package com.microdata.osmpservice.service.user.impl;

import com.microdata.osmpservice.dao.pms.UserDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.po.User;
import com.microdata.osmpservice.service.user.UserService;
import com.microdata.osmpservice.util.CommonUtil;
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
     * @param loginUser json字符串
     * @return
     */
    public PMSResult loginCheck(User loginUser) {
        if(loginUser==null|| CommonUtil.checkStringNullOrEmpty(loginUser.getUserId())
                || CommonUtil.checkStringNullOrEmpty(loginUser.getPassword())){
            pmsResult.setStatus(3);
            pmsResult.setMessage("信息发送有误");
            pmsResult.setData(null);
            return pmsResult;
        }
        //把json字符串转成对象
        User dbUser = userDao.findByUserId(loginUser.getUserId());
        if (dbUser == null) {
            pmsResult.setStatus(1);
            pmsResult.setMessage("用户名不存在");
            pmsResult.setData(null);
        } else if (!loginUser.getPassword().equals(dbUser.getPassword())) {
            pmsResult.setStatus(2);
            pmsResult.setMessage("密码错误");
            pmsResult.setData(null);
        } else {
            pmsResult.setStatus(0);
            pmsResult.setMessage("登陆成功");
            pmsResult.setData(dbUser);
        }
        return pmsResult;
    }
}
