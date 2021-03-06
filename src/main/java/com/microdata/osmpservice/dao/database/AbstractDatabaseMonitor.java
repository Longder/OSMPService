package com.microdata.osmpservice.dao.database;

import com.microdata.osmpservice.entity.po.DbInfo;
import com.microdata.osmpservice.util.CommonUtil;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Longder on 2016/9/13.
 */
public abstract class AbstractDatabaseMonitor implements DatabaseMonitor{
    /**
     * Oracle连接driver
     */
    private static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    /**
     * MySql连接driver
     */
    private static final String ORACLE_DRIVER_NAME = "oracle.jdbc.OracleDriver";

    protected JdbcTemplate jdbcTemplate;
    private BasicDataSource basicDataSource;

    /**
     * 动态初始化JdbcTemplate
     *
     * @param dbInfo
     */
    @Override
    public void initJdbcTemplate(DbInfo dbInfo) {
        basicDataSource = new BasicDataSource();
        if ("MySQL".equalsIgnoreCase(dbInfo.getType())) {
            basicDataSource.setDriverClassName(MYSQL_DRIVER_NAME);
        } else if ("Oracle".equalsIgnoreCase(dbInfo.getType())) {
            basicDataSource.setDriverClassName(ORACLE_DRIVER_NAME);
        }
        basicDataSource.setUrl(CommonUtil.getDatabaseUrl(dbInfo));
        basicDataSource.setUsername(dbInfo.getUsername());
        basicDataSource.setPassword(dbInfo.getPassword());
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(basicDataSource);
    }

    @Override
    protected void finalize() throws Throwable {
        basicDataSource.close();
        super.finalize();
    }

}
