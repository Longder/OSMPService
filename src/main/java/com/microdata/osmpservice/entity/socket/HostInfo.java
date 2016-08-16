package com.microdata.osmpservice.entity.socket;

import java.io.Serializable;

/**
 * 服务器信息（封装从socket实时获取的某个主机信息）
 * Created by Longder on 2016/8/16.
 */
public class HostInfo implements Serializable {
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 设备厂商
     */
    private String manufacturer;
    /**
     * 设备型号
     */
    private String model;
    /**
     * 设备序列号
     */
    private String serialNumber;
    /**
     * CPU配置
     */
    private String cpuName;
    /**
     * CPU核数
     */
    private String cpuCoreNumber;
    /**
     * CPU主频(带单位)
     */
    private String cpuFrequency;
    /**
     * 操作系统描述
     */
    private String os;
    /**
     * 操作系统版本
     */
    private String osVersion;
    /**
     * 内存总大小（带单位）
     */
    private String totalMemory;
    /**
     * 磁盘总容量（带单位）
     */
    private String totalDisk;

    public HostInfo() {
    }

    public HostInfo(String hostInfo) {
        initHostInfo(hostInfo);
    }

    /**
     * 初始化主机信息实体
     */
    public void initHostInfo(String hostInfo) {
        String[] info = hostInfo.split("<string>");
        this.hostName = info[0];
        this.manufacturer = info[1];
        this.model = info[2];
        this.serialNumber = info[3];
        this.cpuName = info[4];
        this.cpuCoreNumber = info[5];
        this.cpuFrequency = info[6];
        this.os = info[7];
        this.osVersion = info[8];
        this.totalMemory = info[9];
        this.totalDisk = info[10];
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getCpuCoreNumber() {
        return cpuCoreNumber;
    }

    public void setCpuCoreNumber(String cpuCoreNumber) {
        this.cpuCoreNumber = cpuCoreNumber;
    }

    public String getCpuFrequency() {
        return cpuFrequency;
    }

    public void setCpuFrequency(String cpuFrequency) {
        this.cpuFrequency = cpuFrequency;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getTotalDisk() {
        return totalDisk;
    }

    public void setTotalDisk(String totalDisk) {
        this.totalDisk = totalDisk;
    }
}
