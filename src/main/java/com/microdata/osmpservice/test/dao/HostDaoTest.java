package com.microdata.osmpservice.test.dao;

import com.microdata.osmpservice.dao.HostDao;
import com.microdata.osmpservice.entity.po.Host;
import org.junit.Assert;
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
public class HostDaoTest {
    @Resource
    private HostDao hostDao;

    @Test
    public void testFindAll() {
        List<Host> hostList = hostDao.findAll();
        System.out.println("集合长度：" + hostList.size());
    }

    @Test
    public void testFindByIpj() {
        Host host = hostDao.findByIp("192.168.1.87");
        Assert.assertNotNull(host);
    }
}
