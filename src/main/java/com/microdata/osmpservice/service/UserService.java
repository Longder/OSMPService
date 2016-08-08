package com.microdata.osmpservice.service;

import com.microdata.osmpservice.entity.PMSResult;

/**
 * Created by Longder on 2016/8/8.
 */
public interface UserService {
    /**
     * 用户登录校验
     * @param userInfo json字符串
     * @return
     */
    PMSResult loginCheck(String userInfo);
}
