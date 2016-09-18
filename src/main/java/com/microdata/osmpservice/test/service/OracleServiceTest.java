package com.microdata.osmpservice.test.service;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.database.OracleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class OracleServiceTest {
    @Resource
    private OracleService oracleService;

    @Test
    public void testLoadDbInfo() {
        PMSResult result = oracleService.loadDatabaseInfoRealTime("127.0.0.1");

    }
}
