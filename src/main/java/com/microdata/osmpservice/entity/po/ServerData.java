package com.microdata.osmpservice.entity.po;


import java.io.Serializable;

/**
 * 对应数据库中 pms_server_data表
 * Created by Longder on 2016/8/19.
 */
public class ServerData implements Serializable {
    private String ip;
    private String time;
    private String cpuRate;
    private String memoryRate;
    private String virtualMemoryRate;
    private String ioReadRate;
    private String ioWriteRate;
    private String storageRate;
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

    public String getIoReadRate() {
        return ioReadRate;
    }

    public void setIoReadRate(String ioReadRate) {
        this.ioReadRate = ioReadRate;
    }

    public String getIoWriteRate() {
        return ioWriteRate;
    }

    public void setIoWriteRate(String ioWriteRate) {
        this.ioWriteRate = ioWriteRate;
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
