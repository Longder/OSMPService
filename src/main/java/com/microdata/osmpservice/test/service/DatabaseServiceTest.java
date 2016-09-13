package com.microdata.osmpservice.test.service;

import com.microdata.osmpservice.service.database.DatabaseService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Longder on 2016/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class DatabaseServiceTest {
    @Resource
    private DatabaseService databaseService;

    @Test
    public void testLoadDatabaseInfo() throws SQLException {
        databaseService.loadDatabaseInfo("127.0.0.1");
    }
}
