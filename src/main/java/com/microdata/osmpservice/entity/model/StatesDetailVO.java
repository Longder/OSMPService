package com.microdata.osmpservice.entity.model;

/**
 * 状态详情
 * Created by Longder on 2016/8/25.
 */
public class StatesDetailVO {
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 服务器状态
     */
    private Integer serverState;
    /**
     * CPU状态
     */
    private Integer cpuState;
    /**
     * 内存状态
     */
    private Integer memoryState;
    /**
     * 电源状态
     */
    private Integer powerState;
    /**
     * 网卡状态
     */
    private Integer networkState;
    /**
     * 主板状态
     */
    private Integer motherboardState;
    /**
     * 风扇状态
     */
    private Integer fanState;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getServerState() {
        return serverState;
    }

    public void setServerState(Integer serverState) {
        this.serverState = serverState;
    }

    public Integer getCpuState() {
        return cpuState;
    }

    public void setCpuState(Integer cpuState) {
        this.cpuState = cpuState;
    }

    public Integer getMemoryState() {
        return memoryState;
    }

    public void setMemoryState(Integer memoryState) {
        this.memoryState = memoryState;
    }

    public Integer getPowerState() {
        return powerState;
    }

    public void setPowerState(Integer powerState) {
        this.powerState = powerState;
    }

    public Integer getNetworkState() {
        return networkState;
    }

    public void setNetworkState(Integer networkState) {
        this.networkState = networkState;
    }

    public Integer getMotherboardState() {
        return motherboardState;
    }

    public void setMotherboardState(Integer motherboardState) {
        this.motherboardState = motherboardState;
    }

    public Integer getFanState() {
        return fanState;
    }

    public void setFanState(Integer fanState) {
        this.fanState = fanState;
    }
}
