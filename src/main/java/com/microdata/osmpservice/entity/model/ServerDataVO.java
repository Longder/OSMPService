package com.microdata.osmpservice.entity.model;

import com.microdata.osmpservice.entity.po.ServerData;

import java.io.Serializable;
import java.util.List;

/**
 * 服务器历史数据VO
 * Created by Longder on 2016/8/23.
 */
public class ServerDataVO implements Serializable {
    /**
     * 从库中分页查询出来的数据
     */
    private List<ServerData> serverData;
    /**
     * 标识出当天的数据是否取完
     * true:取完 false:没有取完
     */
    private Boolean isOver;

    public List<ServerData> getServerData() {
        return serverData;
    }

    public void setServerData(List<ServerData> serverData) {
        this.serverData = serverData;
    }

    public Boolean getOver() {
        return isOver;
    }

    public void setOver(Boolean over) {
        isOver = over;
    }
}
