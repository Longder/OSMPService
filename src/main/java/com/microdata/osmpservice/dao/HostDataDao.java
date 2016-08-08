package com.microdata.osmpservice.dao;

import com.microdata.osmpservice.entity.po.HostData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Longder on 2016/8/8.
 */
@Repository
public interface HostDataDao {
    List<HostData> findAll();
}
