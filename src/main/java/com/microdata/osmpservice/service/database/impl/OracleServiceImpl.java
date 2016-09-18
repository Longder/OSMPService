package com.microdata.osmpservice.service.database.impl;

import com.microdata.osmpservice.dao.database.oracle.OracleDao;
import com.microdata.osmpservice.dao.pms.DbInfoDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.oracle.PGAInfo;
import com.microdata.osmpservice.entity.model.oracle.SessionInfo;
import com.microdata.osmpservice.entity.po.DbInfo;
import com.microdata.osmpservice.service.database.OracleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by Longder on 2016/8/30.
 */
@Service(value = "OracleService")
public class OracleServiceImpl implements OracleService {
    @Resource
    private DbInfoDao dbInfoDao;
    @Resource
    private OracleDao oracleDao;
    @Resource
    private PMSResult pmsResult;

    /**
     * 根据IP获取该IP下数据库的实时信息
     *
     * @param ip
     * @return
     */
    @Override
    public PMSResult loadDatabaseInfoRealTime(String ip) {
        Map<String,Object> databaseInfo = new HashMap<String,Object>();
        DbInfo dbInfo = dbInfoDao.findByIp(ip);
        oracleDao.initJdbcTemplate(dbInfo);
        //会话信息
        SessionInfo sessionInfo = oracleDao.getSessionInfo();
        databaseInfo.put("sessionInfo",sessionInfo);
        //pga信息
        PGAInfo pgaInfo = oracleDao.getPGAInfo();
        //内存排序率，放入pgaInfo中
        pgaInfo.setPctMemorySort(oracleDao.getPctMemorySort());
        //专用连接数和共享连接数，放入pagInfo中
        pgaInfo.setDedicatedServerCount(oracleDao.getPGADedicatedServerCount());
        pgaInfo.setSharedServerCount(oracleDao.getPGASharedServerCount());
        databaseInfo.put("pgaInfo",pgaInfo);
        pmsResult.setStatus(0);
        pmsResult.setMessage("查询成功");
        pmsResult.setData(databaseInfo);
        return pmsResult;
    }
}
