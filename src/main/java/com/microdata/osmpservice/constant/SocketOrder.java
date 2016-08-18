package com.microdata.osmpservice.constant;

/**
 * 发送socket的指令
 * Created by Longder on 2016/8/16.
 */
public final class SocketOrder {
    /**
     * 获取Windows主机信息
     */
    public static final String GET_WINDOWS_HOST_INFO = "getWindowsHostInfo";
    /**
     * 获取Linux主机信息
     */
    public static final String GET_LINUX_HOST_INFO = "getLinuxHostInfo";
    /**
     * 获取PMS监听组件信息
     */
    public static final String GET_WORK_STATION_INFO = "getWorkStationInfo";
    /**
     * 获取内存总量
     */
    public static final String GET_MEMORY_SIZE = "getMemorySize";
    /**
     * 获取内存使用百分比
     */
    public static final String GET_MEMORY_PERCENT = "getMemoryPercent";
    /**
     * 获取存储合计使用百分比
     */
    public static final String GET_STORAGE_TOTAL_PERCENT = "getStorageTotalPercent";
    /**
     * 获取CPU使用百分比
     */
    public static final String GET_CPU_PERCENT = "getCPUPercent";
    /**
     * 获取虚拟内存总量
     */
    public static final String GET_V_MEMORY_SIZE = "getVMemorySize";
    /**
     * 获取虚拟内存使用百分比
     */
    public static final String GET_V_MEMORY_PERCENT = "getVMemoryPercent";
}
