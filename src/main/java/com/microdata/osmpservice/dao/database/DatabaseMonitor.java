package com.microdata.osmpservice.dao.database;

import com.microdata.osmpservice.entity.po.DbInfo;

/**
 * Created by Longder on 2016/9/17.
 */
public interface DatabaseMonitor {

    /**
     * 动态初始化JdbcTemplate
     * @param dbInfo
     */
    void initJdbcTemplate(DbInfo dbInfo);
}
