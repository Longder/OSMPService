package com.microdata.osmpservice.entity.po;

/**
 * 对应表pms_server
 * Created by Longder on 2016/8/8.
 */
public class Server {
    /**
     * ID标识
     */
    private String id;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 监控周期
     */
    private Integer cycle;
    /**
     * 时段起
     */
    private String beginTime;
    /**
     * 时段止
     */
    private String endTime;
    /**
     * CPU阀值
     */
    private Integer cpuWarning;
    /**
     * 内存阀值
     */
    private Integer memoryWarning;
    /**
     * I/O阀值
     */
    private Integer ioWarning;
    /**
     * 虚拟内存阀值
     */
    private Integer virtualMemoryWarning;
    /**
     * 存储阀值
     */
    private String storageWarning;
    /**
     * 监控标志
     */
    private String monitoringFlag;

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

    public Integer getCpuWarning() {
        return cpuWarning;
    }

    public void setCpuWarning(Integer cpuWarning) {
        this.cpuWarning = cpuWarning;
    }

    public Integer getMemoryWarning() {
        return memoryWarning;
    }

    public void setMemoryWarning(Integer memoryWarning) {
        this.memoryWarning = memoryWarning;
    }

    public Integer getIoWarning() {
        return ioWarning;
    }

    public void setIoWarning(Integer ioWarning) {
        this.ioWarning = ioWarning;
    }

    public Integer getVirtualMemoryWarning() {
        return virtualMemoryWarning;
    }

    public void setVirtualMemoryWarning(Integer virtualMemoryWarning) {
        this.virtualMemoryWarning = virtualMemoryWarning;
    }

    public String getStorageWarning() {
        return storageWarning;
    }

    public void setStorageWarning(String storageWarning) {
        this.storageWarning = storageWarning;
    }

    public String getMonitoringFlag() {
        return monitoringFlag;
    }

    public void setMonitoringFlag(String monitoringFlag) {
        this.monitoringFlag = monitoringFlag;
    }
}
