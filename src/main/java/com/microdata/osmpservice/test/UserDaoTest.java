package com.microdata.osmpservice.test;

import com.microdata.osmpservice.dao.UserDao;
import com.microdata.osmpservice.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * UserDao单元测试
 * Created by Longder on 2016/8/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;
    @Test
    public void testFindByUserId() {
        User user = userDao.findByUserId("admin");
        Assert.assertNotNull(user);
    }
}
