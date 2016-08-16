package com.microdata.osmpservice.entity.po;

import java.io.Serializable;

/**
 * 对应数据库中pms_host_data表
 * Created by Longder on 2016/8/8.
 */
public class HostData implements Serializable{
    /**
     * ip地址
     */
    private String ip;
    /**
     * 日期
     */
    private String date;
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 主机功能
     */
    private String function;
    /**
     * 主机类别
     */
    private String category;
    /**
     * 服务接口标识
     */
    private String serverInterfaceFlag;
    /**
     * 主机状态
     */
    private String hostState;
    /**
     * 最后一个状态获取，cpu的使用率
     */
    private String cpu;
    private String cpuWarning;
    private String memory;
    private String memoryWarning;
    private String storage;
    private String storageWarning;
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * 数据库状态
     */
    private String dbState;
    /**
     * 中间件类型
     */
    private String midType;
    /**
     * 中间件状态
     */
    private String midState;
    /**
     * web名称
     */
    private String webName;
    /**
     * web状态
     */
    private String webState;
    private String webOkPercent;
    private String backType;
    private String backState;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getServerInterfaceFlag() {
        return serverInterfaceFlag;
    }

    public void setServerInterfaceFlag(String serverInterfaceFlag) {
        this.serverInterfaceFlag = serverInterfaceFlag;
    }

    public String getHostState() {
        return hostState;
    }

    public void setHostState(String hostState) {
        this.hostState = hostState;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuWarning() {
        return cpuWarning;
    }

    public void setCpuWarning(String cpuWarning) {
        this.cpuWarning = cpuWarning;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemoryWarning() {
        return memoryWarning;
    }

    public void setMemoryWarning(String memoryWarning) {
        this.memoryWarning = memoryWarning;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getStorageWarning() {
        return storageWarning;
    }

    public void setStorageWarning(String storageWarning) {
        this.storageWarning = storageWarning;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDbState() {
        return dbState;
    }

    public void setDbState(String dbState) {
        this.dbState = dbState;
    }

    public String getMidType() {
        return midType;
    }

    public void setMidType(String midType) {
        this.midType = midType;
    }

    public String getMidState() {
        return midState;
    }

    public void setMidState(String midState) {
        this.midState = midState;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebState() {
        return webState;
    }

    public void setWebState(String webState) {
        this.webState = webState;
    }

    public String getWebOkPercent() {
        return webOkPercent;
    }

    public void setWebOkPercent(String webOkPercent) {
        this.webOkPercent = webOkPercent;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public String getBackState() {
        return backState;
    }

    public void setBackState(String backState) {
        this.backState = backState;
    }
}
