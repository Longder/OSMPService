package com.microdata.osmpservice.dao.pms;

import com.microdata.osmpservice.entity.po.DbInfo;
import org.springframework.stereotype.Repository;

/**
 * pms中pms_db表DAO
 * Created by Longder on 2016/9/13.
 */
@Repository
public interface DbInfoDao {
    /**
     * 根据IP查询数据库信息
     *
     * @param ip
     * @return
     */
    DbInfo findByIp(String ip);
}
