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
    private String totalStorage;
    /**
     * 是否填充数据成功 true代表成功 false代表失败
     */
    private boolean fillSuccess;

    public HostInfo() {
    }

    public HostInfo(String hostInfo) {
        initHostInfo(hostInfo);
    }

    /**
     * 初始化主机信息实体
     */
    public void initHostInfo(String hostInfo) {
        if ("0".equals(hostInfo)) {
            this.fillSuccess = false;
        } else {
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
            this.totalStorage = info[10];
            this.fillSuccess = true;
        }
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

    public String getTotalStorage() {
        return totalStorage;
    }

    public void setTotalStorage(String totalStorage) {
        this.totalStorage = totalStorage;
    }

    public boolean isFillSuccess() {
        return fillSuccess;
    }

    public void setFillSuccess(boolean fillSuccess) {
        this.fillSuccess = fillSuccess;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HostInfo{");
        sb.append("hostName='").append(hostName).append('\'');
        sb.append(", manufacturer='").append(manufacturer).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", serialNumber='").append(serialNumber).append('\'');
        sb.append(", cpuName='").append(cpuName).append('\'');
        sb.append(", cpuCoreNumber='").append(cpuCoreNumber).append('\'');
        sb.append(", cpuFrequency='").append(cpuFrequency).append('\'');
        sb.append(", os='").append(os).append('\'');
        sb.append(", osVersion='").append(osVersion).append('\'');
        sb.append(", totalMemory='").append(totalMemory).append('\'');
        sb.append(", totalStorage='").append(totalStorage).append('\'');
        sb.append(", fillSuccess=").append(fillSuccess);
        sb.append('}');
        return sb.toString();
    }
}
