package com.microdata.osmpservice.entity.model;

import java.io.Serializable;

/**
 * 单个磁盘详情
 * Created by Longder on 2016/8/25.
 */
public class DiskDetailVO implements Serializable {
    /**
     * 已用量
     */
    private String used;
    /**
     * 剩余量
     */
    private String free;
    /**
     * 总量
     */
    private String total;
    /**
     * 总量占用率
     */
    private String totalRate;

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }
}
