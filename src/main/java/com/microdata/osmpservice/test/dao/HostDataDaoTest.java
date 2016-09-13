package com.microdata.osmpservice.test.dao;

import com.microdata.osmpservice.dao.pms.HostDataDao;
import com.microdata.osmpservice.entity.po.HostData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Longder on 2016/8/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class HostDataDaoTest {
    @Resource
    private HostDataDao hostDataDao;

    @Test
    public void testFindAll() {
        List<HostData> hostDataList = hostDataDao.findAll();
        System.out.println("集合长度：" + hostDataList.size());
    }
}





