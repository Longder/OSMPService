package com.microdata.osmpservice.entity.po;

/**
 * 对应数据库中pms_host表
 * Created by Longder on 2016/8/8.
 */
public class Host {
    /**
     * 主键
     */
    private String id;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 主机名称
     */
    private String hostName;
    /**
     * 主机功能
     */
    private String function;
    /**
     * 主机类别（Windows,Linux）
     */
    private String category;
    /**
     * 选用标识
     */
    private String chooseFlag;

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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChooseFlag() {
        return chooseFlag;
    }

    public void setChooseFlag(String chooseFlag) {
        this.chooseFlag = chooseFlag;
    }
}
