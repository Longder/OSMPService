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
    /**
     * 多条件查询服务器信息
     *
     * @param conditionMap 条件map
     * @return 服务器列表（封装好的需要显示在APP页面的数据）
     */
    List<ServerVO> findByCondition(Map<String, Object> conditionMap);

}
