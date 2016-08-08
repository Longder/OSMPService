package com.microdata.osmpservice.entity.model;

import java.util.Date;

/**
 * 返回到APP的服务器列表对象，只封装需要显示的信息
 * Created by Longder on 2016/8/8.
 */
public class ServerVO {
    /**
     * 服务器名称
     */
    private String serverName;
    /**
     * ip地址
     */
    private String ip;
    /**
     * 启动时间
     */
    private Date startDate;
    /**
     * 状态
     */
    private String status;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
