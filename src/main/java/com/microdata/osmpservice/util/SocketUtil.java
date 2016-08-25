package com.microdata.osmpservice.util;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.entity.model.DiskDetailVO;
import com.microdata.osmpservice.entity.socket.HostInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Socket访问工具类
 * Created by Longder on 2016/8/1.
 */
public class SocketUtil {
    /**
     * PMS端口号
     */
    public static final int PMS_PORT = 12345;
    /**
     * 小数格式化工具，默认保留一位小数
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("######0.0");
    /**
     * 缓冲内存详情的map
     */
    private static final Map<Integer, String> memoryDetail = new HashMap<Integer, String>();
    /**
     * 缓冲虚拟内存详情的map
     */
    private static final Map<Integer, String> vMemoryDetail = new HashMap<Integer, String>();
    /**
     * 缓冲磁盘详情的map
     */
    private static final Map<Integer, String> storageDetail = new HashMap<Integer, String>();
    /**
     * map中的key定义
     */
    public static final int TOTAL_MEMORY = 0;
    public static final int MEMORY_RATE = 1;
    public static final int FREE_MEMORY = 2;
    public static final int USED_MEMORY = 3;

    public static final int TOTAL_V_MEMORY = 0;
    public static final int V_MEMORY_RATE = 1;
    public static final int FREE_V_MEMORY = 2;
    public static final int USED_V_MEMORY = 3;

    public static final int TOTAL_STORAGE = 0;
    public static final int STORAGE_RATE = 1;
    public static final int FREE_STORAGE = 2;
    public static final int USED_STORAGE = 3;
    /**
     * 根据指令动态获取主机信息
     *
     * @return
     */

    /**
     * 根据IP获取CPU实时占用百分比(不带单位)
     *
     * @return
     */
    public static Double getCPURate(String ip) {
        String cpuPercent = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_CPU_PERCENT);
        if (!"0".equals(cpuPercent)) {
            return Double.parseDouble(DECIMAL_FORMAT.format(Double.parseDouble(cpuPercent)));
        } else {
            return 0D;
        }
    }

    /**
     * 根据IP获取内存实时占用百分比（不带单位）
     *
     * @return
     */
    public static Double getMemoryRate(String ip) {
        String memoryRate = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_MEMORY_PERCENT);
        if (!"0".equals(memoryRate)) {
            return Double.parseDouble(DECIMAL_FORMAT.format(Double.parseDouble(memoryRate)));
        } else {
            return 0D;
        }
    }

    /**
     * 实时获取内存详情
     */
    public static Map<Integer, String> getMemoryDetail(String ip) {
        //总内存
        String totalMemory = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_MEMORY_SIZE);
        //内存使用率
        String memoryRate = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_MEMORY_PERCENT);
        //剩余内存
        String freeMemory = getResidualCapacityByRate(totalMemory, memoryRate);
        //已用内存
        String usedMemory = getUsedCapacityByRate(totalMemory, memoryRate);
        //构建map
        memoryDetail.put(TOTAL_MEMORY, totalMemory + "G");
        memoryDetail.put(MEMORY_RATE, memoryRate);
        memoryDetail.put(FREE_MEMORY, freeMemory);
        memoryDetail.put(USED_MEMORY, usedMemory);
        return memoryDetail;
    }

    /**
     * 实时获取虚拟内存详情
     */
    public static Map<Integer, String> getVMemoryDetail(String ip) {
        //总虚拟内存
        String totalVMemory = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_V_MEMORY_SIZE);
        //虚拟内存使用率
        String vMemoryRate = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_V_MEMORY_PERCENT);
        //剩余内存
        String freeVMemory = getResidualCapacityByRate(totalVMemory, vMemoryRate);
        //已用虚拟内存
        String usedVMemory = getUsedCapacityByRate(totalVMemory, vMemoryRate);
        //构建map
        vMemoryDetail.put(TOTAL_V_MEMORY, totalVMemory + "G");
        vMemoryDetail.put(V_MEMORY_RATE, vMemoryRate);
        vMemoryDetail.put(FREE_V_MEMORY, freeVMemory);
        vMemoryDetail.put(USED_V_MEMORY, usedVMemory);
        return vMemoryDetail;
    }

    /**
     * 实时获取存储详情
     *
     * @param ip
     * @return
     */
    public static Map<Integer, String> getStorageDetail(String ip) {
        //总磁盘容量
        String totalStorage = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_STORAGE_TOTAL_SIZE);
        //磁盘使用率
        String storageRate = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_STORAGE_TOTAL_PERCENT);
        //剩余磁盘
        String freeStorage = getResidualCapacityByRate(totalStorage, storageRate);
        //已用磁盘
        String usedStorage = getUsedCapacityByRate(totalStorage, storageRate);
        //构建map
        storageDetail.put(TOTAL_STORAGE, totalStorage + "G");
        storageDetail.put(STORAGE_RATE, storageRate);
        storageDetail.put(FREE_STORAGE, freeStorage);
        storageDetail.put(USED_STORAGE, usedStorage);
        return storageDetail;
    }

    /**
     * 实时获取磁盘详情
     *
     * @return
     */
    public static Map<String, DiskDetailVO> getDiskDetail(String ip, String totalStorage) {
        Map<String, DiskDetailVO> diskMap = new HashMap<String, DiskDetailVO>();
        String diskInfo = SocketConnectionHandler.getInfo(ip, SocketOrder.GET_DISK_INFO);
        String[] data = diskInfo.split("<string>");
        for (int i = 2; i < data.length; i += 3) {
            DiskDetailVO diskDetail = new DiskDetailVO();
            diskDetail.setUsed(CommonUtil.convertKBtoGB(data[i - 2]));
            diskDetail.setTotal(CommonUtil.convertKBtoGB(data[i]));
            diskDetail.setFree(CommonUtil.convertKBtoGB(getResidualCapacityByUsed(data[i], data[i - 2])));
            diskDetail.setTotalRate(CommonUtil.getPersent(CommonUtil.convertKBtoGB(data[i]), totalStorage));
            diskMap.put(data[i - 1], diskDetail);
        }
        return diskMap;
    }

    /**
     * 根据总容量，使用百分比计算剩余容量(带单位)
     *
     * @param totalCapacity 总容量（带单位，固定是G）
     * @param usagePercent  使用百分比（不带单位）
     * @return 剩余容量，带单位
     */
    private static String getResidualCapacityByRate(String totalCapacity, String usagePercent) {
        String residualCapacity;
        //截取并转换为数字，换算为MB
        double total;
        if (totalCapacity.endsWith("G")) {
            total = Double.parseDouble(totalCapacity.substring(0, totalCapacity.length() - 1)) * 1024;
        } else {
            total = Double.parseDouble(totalCapacity) * 1024;
        }
        //处理百分比
        double percent = (100 - Double.parseDouble(usagePercent)) / 100;
        //计算
        double free = total * percent;
        //处理单位，判断数据是否大于1024，如果大于就转换成GB单位，否则就用MB单位
        if (free > 1024) {
            residualCapacity = DECIMAL_FORMAT.format(free / 1024) + "GB";
        } else {
            residualCapacity = DECIMAL_FORMAT.format(free);
        }
        return residualCapacity;
    }

    /**
     * 根据总容量，使用百分比计算已用容量（带单位）
     *
     * @param totalCapacity 总容量（带单位，固定是G）
     * @param usagePercent  使用百分比（不带单位）
     * @return 已用容量，带单位
     */
    private static String getUsedCapacityByRate(String totalCapacity, String usagePercent) {
        String usedCapacity;
        //截取并转换为数字，换算为MB
        double total;
        if (totalCapacity.endsWith("G")) {
            total = Double.parseDouble(totalCapacity.substring(0, totalCapacity.length() - 1)) * 1024;
        } else {
            total = Double.parseDouble(totalCapacity) * 1024;
        }
        //处理百分比
        double percent = Double.parseDouble(usagePercent) / 100;
        //计算
        double free = total * percent;
        //处理单位，判断数据是否大于1024，如果大于就转换成GB单位，否则就用MB单位
        if (free > 1024) {
            usedCapacity = DECIMAL_FORMAT.format(free / 1024) + "GB";
        } else {
            usedCapacity = DECIMAL_FORMAT.format(free);
        }
        return usedCapacity;
    }

    /**
     * 根据总容量，已用容量计算剩余容量
     *
     * @param totalCapacity
     * @param usedCapacity
     * @return
     */
    private static String getResidualCapacityByUsed(String totalCapacity, String usedCapacity) {
        double total = Double.parseDouble(totalCapacity);
        double used = Double.parseDouble(usedCapacity);
        return String.valueOf(total - used);
    }
}







