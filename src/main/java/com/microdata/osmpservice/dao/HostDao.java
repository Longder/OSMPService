package com.microdata.osmpservice.dao;

import com.microdata.osmpservice.entity.po.Host;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Created by Longder on 2016/8/8.
 */
@Repository
public interface HostDao {
    /**
     * 查询所有
     * @return
     */
    List<Host> findAll();
}
