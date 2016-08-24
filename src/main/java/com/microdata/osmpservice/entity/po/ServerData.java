package com.microdata.osmpservice.entity.po;


import java.io.Serializable;

/**
 * 对应数据库中 pms_server_data表
 * Created by Longder on 2016/8/19.
 */
public class ServerData implements Serializable {
    /**
     * ip地址
     */
    private String ip;
    /**
     * 记录时间
     */
    private String time;
    /**
     * CPU使用率
     */
    private String cpuRate;
    /**
     * 内存使用率
     */
    private String memoryRate;
    /**
     * 虚拟内存使用率
     */
    private String virtualMemoryRate;
    /**
     * io读取KPS
     */
    private String ioReadKps;
    /**
     * io写入KPS
     */
    private String ioWriteKps;
    /**
     * 磁盘使用率
     */
    private String storageRate;
    /**
     * 状态
     */
    private String status;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(String cpuRate) {
        this.cpuRate = cpuRate;
    }

    public String getMemoryRate() {
        return memoryRate;
    }

    public void setMemoryRate(String memoryRate) {
        this.memoryRate = memoryRate;
    }

    public String getVirtualMemoryRate() {
        return virtualMemoryRate;
    }

    public void setVirtualMemoryRate(String virtualMemoryRate) {
        this.virtualMemoryRate = virtualMemoryRate;
    }

    public String getIoReadKps() {
        return ioReadKps;
    }

    public void setIoReadKps(String ioReadKps) {
        this.ioReadKps = ioReadKps;
    }

    public String getIoWriteKps() {
        return ioWriteKps;
    }

    public void setIoWriteKps(String ioWriteKps) {
        this.ioWriteKps = ioWriteKps;
    }

    public String getStorageRate() {
        return storageRate;
    }

    public void setStorageRate(String storageRate) {
        this.storageRate = storageRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
