package com.microdata.osmpservice.util;

import com.microdata.osmpservice.constant.SocketOrder;
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
    private static final int PMS_PORT = 12345;
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
    public static Socket client = null;
    /**
     * 根据指令动态获取主机信息
     *
     * @return
     */
    public static String getHostInfo(String ip, String order) {
        String info = "0";
        try {
/*            //先pingip
            boolean status = InetAddress.getByName(ip).isReachable(3000);
            if (!status) {
                info = "0";
            } else {*/
            if(client==null){
                client = new Socket(ip,PMS_PORT);
            }
            //client.setSoTimeout(5000);
            final DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(order);
            DataInputStream in = new DataInputStream(client.getInputStream());
            info = in.readUTF();
/*            out.close();
            in.close();*/
            //}
        } catch (Exception e) {
            e.printStackTrace();
            info = "0";
        } finally {
/*            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    info = "0";
                }
            }*/
        }
        return info;
    }

    /**
     * 根据IP获取CPU实时占用百分比(不带单位)
     *
     * @return
     */
    public static Double getCPURate(String ip) {
        String cpuPercent = getHostInfo(ip, SocketOrder.GET_CPU_PERCENT);
        if (!"0".equals(cpuPercent)) {
            return Double.parseDouble(DECIMAL_FORMAT.format(Double.parseDouble(cpuPercent)));
        } else {
            return 0D;
        }
    }

    /**
     * 实时获取内存详情
     */
    public static Map<Integer, String> getMemoryDetail(String ip) {
        //总内存
        String totalMemory = getHostInfo(ip, SocketOrder.GET_MEMORY_SIZE);
        //内存使用率
        String memoryRate = getHostInfo(ip, SocketOrder.GET_MEMORY_PERCENT);
        //剩余内存
        String freeMemory = getResidualCapacity(totalMemory, memoryRate);
        //已用内存
        String usedMemory = getUsedCapacity(totalMemory, memoryRate);
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
        String totalVMemory = getHostInfo(ip, SocketOrder.GET_V_MEMORY_SIZE);
        //虚拟内存使用率
        String vMemoryRate = getHostInfo(ip, SocketOrder.GET_V_MEMORY_PERCENT);
        //剩余内存
        String freeVMemory = getResidualCapacity(totalVMemory, vMemoryRate);
        //已用虚拟内存
        String usedVMemory = getUsedCapacity(totalVMemory, vMemoryRate);
        //构建map
        vMemoryDetail.put(TOTAL_V_MEMORY, totalVMemory + "G");
        vMemoryDetail.put(V_MEMORY_RATE, vMemoryRate);
        vMemoryDetail.put(FREE_V_MEMORY, freeVMemory);
        vMemoryDetail.put(USED_V_MEMORY, usedVMemory);
        return vMemoryDetail;
    }

    /**
     * 根据总容量，使用百分比计算剩余容量
     *
     * @param totalCapacity 总容量（带单位，固定是G）
     * @param usagePercent  使用百分比（不带单位）
     * @return 剩余容量，带单位
     */
    public static String getResidualCapacity(String totalCapacity, String usagePercent) {
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
    public static String getUsedCapacity(String totalCapacity, String usagePercent) {
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

}







