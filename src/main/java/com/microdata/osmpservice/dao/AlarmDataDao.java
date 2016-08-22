package com.microdata.osmpservice.dao;

import com.microdata.osmpservice.entity.model.AlarmDataVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * pms_alarm_data表Dao
 * Created by Longder on 2016/8/22.
 */
@Repository
public interface AlarmDataDao {
    /**
     * 条件查询告警信息
     *
     * @param condition
     * @return
     */
    List<AlarmDataVO> findByCondition(Map<String, Object> condition);
}
