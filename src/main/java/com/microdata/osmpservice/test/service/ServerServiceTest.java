package com.microdata.osmpservice.test.service;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.ServerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class ServerServiceTest {
    @Resource
    private ServerService serverService;

    @Test
    public void testLoadServerList() {
        String page = "1";
        String pageSize = "3";
        String category = null;
        PMSResult result = serverService.loadServerList(page, pageSize, category);
        System.out.println(result);
    }

    @Test
    public void testLoadServerDetail() {
        PMSResult result = serverService.loadServerDetailRealTime("192.168.1.87");
        System.out.println(result);
    }
}
