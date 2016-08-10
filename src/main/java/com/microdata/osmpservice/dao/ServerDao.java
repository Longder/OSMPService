package com.microdata.osmpservice.dao;

import com.microdata.osmpservice.entity.model.ServerVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 服务器信息操作dao
 * Created by Longder on 2016/8/10.
 */
@Repository
public interface ServerDao {
    List<ServerVO> findByCondition(Map<String,Object> conditionMap);
}
