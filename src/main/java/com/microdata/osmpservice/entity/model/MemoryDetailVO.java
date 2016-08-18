package com.microdata.osmpservice.entity.model;

/**
 * 内存详情封装实体
 * Created by Longder on 2016/8/18.
 */
public class MemoryDetailVO {
    /**
     * 总内存（带单位）
     */
    private String totalMemory;
    /**
     * 可用内存（带单位）
     */
    private String freeMemory;
    /**
     * 已用内存（带单位）
     */
    private String usedMemory;
    /**
     * 内存百分比（不带单位）
     */
    private String memoryRate;
    /**
     * 虚拟内存总量（带单位）
     */
    private String totalVMemory;
    /**
     * 剩余虚拟内存（带单位）
     */
    private String freeVMemory;
    /**
     * 虚拟内存使用百分比（不带单位）
     */
    private String VMemoryRate;
    /**
     * 已用虚拟内存（带单位）
     */
    private String usedVMemory;

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(String freeMemory) {
        this.freeMemory = freeMemory;
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getMemoryRate() {
        return memoryRate;
    }

    public void setMemoryRate(String memoryRate) {
        this.memoryRate = memoryRate;
    }

    public String getTotalVMemory() {
        return totalVMemory;
    }

    public void setTotalVMemory(String totalVMemory) {
        this.totalVMemory = totalVMemory;
    }

    public String getFreeVMemory() {
        return freeVMemory;
    }

    public void setFreeVMemory(String freeVMemory) {
        this.freeVMemory = freeVMemory;
    }

    public String getVMemoryRate() {
        return VMemoryRate;
    }

    public void setVMemoryRate(String VMemoryRate) {
        this.VMemoryRate = VMemoryRate;
    }

    public String getUsedVMemory() {
        return usedVMemory;
    }

    public void setUsedVMemory(String usedVMemory) {
        this.usedVMemory = usedVMemory;
    }
}
