package com.microdata.osmpservice.entity.model.oracle;

import com.microdata.osmpservice.util.CommonUtil;

/**
 * Created by Longder on 2016/9/17.
 */
public class PGAInfo {
    /**
     * PGA目标尺寸（带单位）
     */
    private String target;
    /**
     * PGA当前尺寸（带单位）
     */
    private String current;
    /**
     * PGA使用率（不带单位）
     */
    private Double usage;
    /**
     * 内存排序率（不带单位）
     */
    private Double pctMemorySort;
    /**
     * 专用连接数
     */
    private Integer dedicatedServerCount;
    /**
     * 共享连接数
     */
    private Integer sharedServerCount;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = CommonUtil.convertByte(target);
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = CommonUtil.convertByte(current);
    }

    public Double getUsage() {
        return usage;
    }

    public void setUsage(Double usage) {
        this.usage = usage;
    }

    public Double getPctMemorySort() {
        return pctMemorySort;
    }

    public void setPctMemorySort(Double pctMemorySort) {
        this.pctMemorySort = pctMemorySort;
    }

    public Integer getDedicatedServerCount() {
        return dedicatedServerCount;
    }

    public void setDedicatedServerCount(Integer dedicatedServerCount) {
        this.dedicatedServerCount = dedicatedServerCount;
    }

    public Integer getSharedServerCount() {
        return sharedServerCount;
    }

    public void setSharedServerCount(Integer sharedServerCount) {
        this.sharedServerCount = sharedServerCount;
    }
}
