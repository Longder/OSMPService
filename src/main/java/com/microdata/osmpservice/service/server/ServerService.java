package com.microdata.osmpservice.service.server;

import com.microdata.osmpservice.entity.PMSResult;

/**
 * Created by Longder on 2016/8/10.
 */
public interface ServerService {
    /**
     * 加载服务器信息列表
     *
     * @param page     页数
     * @param pageSize 页容量
     * @param category 类别
     * @return
     */
    PMSResult loadServerList(String page, String pageSize, String category);

    /**
     * 根据IP实时加载服务器详情
     *
     * @param ip ip地址
     * @return
     */
    PMSResult loadServerDetailRealTime(String ip);

    /**
     * 根据IP实时加载内存详情
     *
     * @param ip
     * @return
     */
    PMSResult loadMemoryDetailRealTime(String ip);

    /**
     * 加载服务器历史数据
     *
     * @param ip
     * @return
     */
    PMSResult loadServerHistory(String ip, String day, String page, String pageSize);

    /**
     * 根据IP实时加载CPU详情
     *
     * @param ip
     * @return
     */
    PMSResult loadCPUDetailRealTime(String ip);

    /**
     * 根据ip，分页信息加载服务器告警信息
     *
     * @param ip
     * @param page
     * @param pageSize
     * @return
     */
    PMSResult loadAlarmData(String ip, String page, String pageSize);

    /**
     * 根据IP加载服务器硬件详情
     *
     * @param ip
     * @return
     */
    PMSResult loadHardwareDetail(String ip);

    /**
     * 根据ip加载服务器磁盘信息（实时）
     *
     * @param ip
     * @return
     */
    PMSResult loadStorageDetailRealTime(String ip);

    /**
     * 根据ip加载服务器各状态信息（实时）
     * @param ip
     * @return
     */
    PMSResult loadStatesDetailRealTime(String ip);
}
