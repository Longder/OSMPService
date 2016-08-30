package com.microdata.osmpservice.service.user;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.po.User;

/**
 * Created by Longder on 2016/8/8.
 */
public interface UserService {
    /**
     * 用户登录校验
     * @param loginUser json字符串
     * @return
     */
    PMSResult loginCheck(User loginUser);
}
