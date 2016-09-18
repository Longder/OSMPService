package com.microdata.osmpservice.service.database.impl;

import com.microdata.osmpservice.dao.database.mysql.MysqlDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.database.MysqlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/9/18.
 */
@Service(value = "MysqlService")
public class MysqlServiceImpl implements MysqlService {
    @Resource(name = "MysqlDao")
    private MysqlDao mysqlDao;
    @Resource
    private PMSResult pmsResult;

    /**
     * 根据IP获取该IP下数据库的实时信息
     *
     * @param ip
     * @return
     */
    @Override
    public PMSResult loadDatabaseInfoRealTime(String ip) {
        pmsResult.setStatus(3);
        pmsResult.setMessage("MYSQL暂未实现");
        pmsResult.setData(null);
        return pmsResult;
    }
}
