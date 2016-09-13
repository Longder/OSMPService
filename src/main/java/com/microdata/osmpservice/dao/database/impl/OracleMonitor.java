package com.microdata.osmpservice.dao.database.impl;

import com.microdata.osmpservice.dao.database.AbstractDatabaseMonitor;
import org.springframework.stereotype.Component;

/**
 * Created by Longder on 2016/9/13.
 */
@Component
public class OracleMonitor extends AbstractDatabaseMonitor {

    @Override
    public int getServicesProcNum() {
        String sql = "select count(*) as \"NUM\" from v$session where USERNAME not in ('DBSNMP','SYSMAN','SYS') and USERNAME is not null and SERVER = 'DEDICATED'";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
