package com.microdata.osmpservice.util;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * Created by Longder on 2016/8/30.
 */
public class DynamicDataSourceHandler extends AbstractRoutingDataSource{
    private static BasicDataSource basicDataSource = new BasicDataSource();

    private static void setBasicDataSource(String driverName, String url, String username, String password) {
        basicDataSource.setDriverClassName(driverName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("111");
        return "user";
    }

    @Override
    protected DataSource determineTargetDataSource() {
        System.out.println("222");
        setBasicDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/pms?serverTimezone=GMT%2b8", "root", "123456");
        return basicDataSource;
    }
}
