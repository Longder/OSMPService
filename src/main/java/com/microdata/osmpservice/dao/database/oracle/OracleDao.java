package com.microdata.osmpservice.dao.database.oracle;

import com.microdata.osmpservice.dao.database.AbstractDatabaseMonitor;
import com.microdata.osmpservice.entity.model.oracle.PGAInfo;
import com.microdata.osmpservice.entity.model.oracle.SessionInfo;


/**
 * Created by Longder on 2016/9/13.
 */
public abstract class OracleDao extends AbstractDatabaseMonitor {
    /**
     * 获取会话信息（包括总会话数，活动会话数）
     *
     * @return ACTIVE:总会话数 INACTIVE：活动会话数
     */
    public abstract SessionInfo getSessionInfo();

    /**
     * 获取PGA信息（目标尺寸，当前尺寸，PGA使用率）
     *
     * @return
     */
    public abstract PGAInfo getPGAInfo();

    /**
     * 获取PGA内存排序率
     *
     * @return
     */
    public abstract Double getPctMemorySort();

    /**
     * 获取PGA专用连接数
     * @return
     */
    public abstract Integer getPGADedicatedServerCount();

    /**
     * 获取PGA共享连接数
     * @return
     */
    public abstract Integer getPGASharedServerCount();


}
