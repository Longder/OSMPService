package com.microdata.osmpservice.dao.database.oracle.impl;

import com.microdata.osmpservice.dao.database.oracle.OracleDao;
import com.microdata.osmpservice.entity.model.oracle.PGAInfo;
import com.microdata.osmpservice.entity.model.oracle.SessionInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Longder on 2016/9/17.
 */
@Component(value = "OracleDao")
public class OracleDaoImpl extends OracleDao {
    /**
     * 获取会话信息（包括总会话数，活动会话数）
     *
     * @return ACTIVE:总会话数 INACTIVE：活动会话数
     */
    @Override
    public SessionInfo getSessionInfo() {
        String sql = "select status,count(*) as \"SESSIONS\" from v$session group by status  having status in ('INACTIVE','ACTIVE')";
        SessionInfo sessionInfo = jdbcTemplate.query(sql, new ResultSetExtractor<SessionInfo>() {
            @Override
            public SessionInfo extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                SessionInfo info = new SessionInfo();
                while (resultSet.next()) {
                    if ("ACTIVE".equals(resultSet.getString("STATUS"))) {
                        info.setActiveSession(resultSet.getInt("SESSIONS"));
                    } else if ("INACTIVE".equals(resultSet.getString("STATUS"))) {
                        info.setInActiveSession(resultSet.getInt("SESSIONS"));
                    }
                }
                return info;
            }
        });
        return sessionInfo;
    }

    /**
     * 获取PGA信息（目标尺寸，当前尺寸，PGA使用率）
     *
     * @return
     */
    @Override
    public PGAInfo getPGAInfo() {
        String sql = "select a.value as pgaTarget,b.value as pgaUsed,round(b.value/a.value,2) as pgaUsage from v$pgastat a,v$pgastat b where a.name='total PGA allocated' and b.name='total PGA inuse'";
        PGAInfo pgaInfo = jdbcTemplate.queryForObject(sql, new RowMapper<PGAInfo>() {
            @Override
            public PGAInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                PGAInfo info = new PGAInfo();
                info.setTarget(resultSet.getString("pgaTarget"));
                info.setCurrent(resultSet.getString("pgaUsed"));
                info.setUsage(resultSet.getDouble("pgaUsage"));
                return info;
            }
        });
        return pgaInfo;
    }

    /**
     * 获取PGA内存排序率
     *
     * @return
     */
    @Override
    public Double getPctMemorySort() {
        String sql = "select round((100*b.value)/decode((a.value+b.value),0,1,(a.value+b.value)),2) as Pct_Memory_Sorts from v$sysstat a,v$sysstat b where a.name = 'sorts (disk)' and b.name = 'sorts (memory)'";
        return jdbcTemplate.queryForObject(sql, Double.class);
    }

    /**
     * 获取PGA专用连接数
     *
     * @return
     */
    @Override
    public Integer getPGADedicatedServerCount() {
        String sql = "select count(*) as dedicated_num from v$session where USERNAME not in ('DBSNMP','SYSMAN','SYS') and USERNAME is not null and SERVER = 'DEDICATED'";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    /**
     * 获取PGA共享连接数
     *
     * @return
     */
    @Override
    public Integer getPGASharedServerCount() {
        String sql = "select value as shared_num from v$parameter where NAME ='shared_servers'";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
