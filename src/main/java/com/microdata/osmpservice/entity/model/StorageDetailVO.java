package com.microdata.osmpservice.entity.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 服务器磁盘详情VO
 * Created by Longder on 2016/8/25.
 */
public class StorageDetailVO implements Serializable {
    /**
     * 总量
     */
    private String total;
    /**
     * 剩余量
     */
    private String free;
    /**
     * 已用量
     */
    private String used;
    /**
     * 此map是封装服务器下所有的磁盘详情
     * key:盘符（C盘，D盘...）
     * value:某个磁盘的详情
     */
    private Map<String, DiskDetailVO> diskDetails;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public Map<String, DiskDetailVO> getDiskDetails() {
        return diskDetails;
    }

    public void setDiskDetails(Map<String, DiskDetailVO> diskDetails) {
        this.diskDetails = diskDetails;
    }
}
