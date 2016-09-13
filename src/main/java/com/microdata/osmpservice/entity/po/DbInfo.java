package com.microdata.osmpservice.entity.po;

/**
 * pms表中数据库信息实体
 * Created by Longder on 2016/9/13.
 */
public class DbInfo {
    /**
     * 主键
     */
    private String id;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 数据库类型
     */
    private String type;
    /**
     * 数据库名
     */
    private String name;
    /**
     * 数据库登录名
     */
    private String username;
    /**
     * 数据库登录密码
     */
    private String password;
    /**
     * 数据库端口号
     */
    private String port;
    /**
     * 监控周期
     */
    private Integer cycle;
    /**
     * 监控开始时间
     */
    private String beginTime;
    /**
     * 监控结束时间
     */
    private String endTime;
    /**
     * 监控标志
     */
    private Character monitoringFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Character getMonitoringFlag() {
        return monitoringFlag;
    }

    public void setMonitoringFlag(Character monitoringFlag) {
        this.monitoringFlag = monitoringFlag;
    }
}
