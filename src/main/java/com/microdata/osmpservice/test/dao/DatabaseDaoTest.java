package com.microdata.osmpservice.test.dao;

import com.microdata.osmpservice.dao.pms.DbInfoDao;
import com.microdata.osmpservice.entity.po.DbInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Longder on 2016/9/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class DatabaseDaoTest {
    @Resource
    private DbInfoDao dbInfoDao;

    @Test
    public void testFindByIp() {
        DbInfo dbInfo = dbInfoDao.findByIp("192.168.1.2");
        System.out.println(dbInfo);


    }
}
