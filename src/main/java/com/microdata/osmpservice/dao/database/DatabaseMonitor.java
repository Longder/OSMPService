package com.microdata.osmpservice.dao.database;


import com.microdata.osmpservice.entity.po.DbInfo;

import java.util.Map;

/**
 * Created by Longder on 2016/9/13.
 */
public interface DatabaseMonitor {
    String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    String ORACLE_DRIVER_NAME = "oracle.jdbc.OracleDriver";
    /**
     * 动态初始化JdbcTemplate
     * @param dbInfo
     */
    void initJdbcTemplate(DbInfo dbInfo);

    /**
     * 查询专用服务器进程数
     * @return
     */
    int getServicesProcNum();

    /**
     * 获取会话信息
     *  active:总会话数
     *  inactive:等待中会话数（当前活动）
     * @return
     */
    Map<String,Integer> getSessionInfo();



}
