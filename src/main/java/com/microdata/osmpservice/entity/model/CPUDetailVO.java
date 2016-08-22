package com.microdata.osmpservice.entity.model;

import java.io.Serializable;

/**
 * CPU动态详情
 * Created by Longder on 2016/8/22.
 */
public class CPUDetailVO implements Serializable {
    /**
     * 已使用百分比（不带单位）
     */
    private String usedRate;
    /**
     * 剩余百分比
     */
    private String freeRate;
    /**
     * CPU型号
     */
    private String model;
    /**
     * CPU主频
     */
    private String frequency;

    public String getUsedRate() {
        return usedRate;
    }

    public void setUsedRate(String usedRate) {
        this.usedRate = usedRate;
    }

    public String getFreeRate() {
        return freeRate;
    }

    public void setFreeRate(String freeRate) {
        this.freeRate = freeRate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
