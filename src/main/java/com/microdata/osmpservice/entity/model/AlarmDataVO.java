package com.microdata.osmpservice.entity.model;

import java.io.Serializable;

/**
 * 告警数据
 * Created by Longder on 2016/8/22.
 */
public class AlarmDataVO implements Serializable {
    /**
     * 告警状态
     */
    private String state;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 类型
     */
    private String type;
    /**
     * 告警持续时间
     */
    private String durationTime;
    /**
     * 告警时间
     */
    private String time;
    /**
     * 告警内容
     */
    private String info;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
