package com.microdata.osmpservice.service.database;

import com.microdata.osmpservice.entity.PMSResult;

/**
 * Created by Longder on 2016/8/30.
 */
public interface DatabaseService {
    /**
     * 根据IP获取该IP下数据库的实时信息
     * @param ip
     * @return
     */
    PMSResult loadDatabaseInfoRealTime(String ip);
}
