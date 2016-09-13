package com.microdata.osmpservice.dao.pms;

import com.microdata.osmpservice.entity.po.User;
import org.springframework.stereotype.Repository;

/**
 * 用户表持久层
 * Created by Longder on 2016/8/4.
 */
@Repository
public interface UserDao {
    /**
     * 根据userId查询
     * @param userId
     * @return 用户对象
     */
    User findByUserId(String userId);
}
