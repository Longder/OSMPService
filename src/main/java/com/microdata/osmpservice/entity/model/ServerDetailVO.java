package com.microdata.osmpservice.entity.model;

import java.io.Serializable;

/**
 * Created by Longder on 2016/8/15.
 */
public class ServerDetailVO implements Serializable{
    /**
     * 剩余内存（带单位）
     */
    private String freeMemory;
    /**
     * 剩余硬盘容量（带单位）
     */
    private String freeDisk;
    /**
     * 内存占用率（保留一位小数）
     */
    private Double memoryRate;
    /**
     * CPU占用率（保留一位小数）
     */
    private Double cpuRate;

    public String getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(String freeMemory) {
        this.freeMemory = freeMemory;
    }

    public String getFreeDisk() {
        return freeDisk;
    }

    public void setFreeDisk(String freeDisk) {
        this.freeDisk = freeDisk;
    }

    public Double getMemoryRate() {
        return memoryRate;
    }

    public void setMemoryRate(Double memoryRate) {
        this.memoryRate = memoryRate;
    }

    public Double getCpuRate() {
        return cpuRate;
    }

    public void setCpuRate(Double cpuRate) {
        this.cpuRate = cpuRate;
    }
}
