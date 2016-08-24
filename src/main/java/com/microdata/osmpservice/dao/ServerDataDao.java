package com.microdata.osmpservice.dao;

import com.microdata.osmpservice.entity.po.ServerData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 操作表pms_server_data对象
 * Created by Longder on 2016/8/19.
 */
@Repository
public interface ServerDataDao {

    List<ServerData> findByIpAndTime(Map<String, Object> condition);

    Integer findCountByIp(Map<String, Object> condition);
}
