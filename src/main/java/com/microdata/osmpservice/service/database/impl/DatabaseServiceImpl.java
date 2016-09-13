package com.microdata.osmpservice.service.database.impl;

import com.microdata.osmpservice.dao.database.DatabaseMonitor;
import com.microdata.osmpservice.dao.pms.DbInfoDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.po.DbInfo;
import com.microdata.osmpservice.service.database.DatabaseService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 数据库监控相关
 * Created by Longder on 2016/8/30.
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {
    @Resource
    private DbInfoDao dbInfoDao;
    @Resource
    private DatabaseMonitor databaseMonitor;

    /**
     * 根据IP获取该IP下数据库的实时性能信息
     *
     * @param ip
     * @return
     */
    @Override
    public PMSResult loadDatabaseInfo(String ip) {
        //根据ip去pms表中查询数据库连接信息
        DbInfo dbInfo = dbInfoDao.findByIp(ip);
        //初始化数据库监控器
        databaseMonitor.initJdbcTemplate(dbInfo);
        int count = databaseMonitor.getServicesProcNum();
        return null;
    }
}
