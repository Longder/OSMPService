package com.microdata.osmpservice.controller;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.ServerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/8/10.
 */
@RestController
@RequestMapping(value = "/server")
public class ServerController {
    @Resource
    private ServerService serverService;

    /**
     * 分页加载服务器列表详情
     *
     * @param page     页数
     * @param pageSize 页容量
     * @param category 服务器类别
     * @return
     */
    @RequestMapping(value = "/list")
    public PMSResult list(@RequestParam(value = "page", defaultValue = "1") String page,
                          @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                          @RequestParam(value = "category", defaultValue = "") String category) {
        return serverService.loadServerList(page, pageSize, category);
    }

    /**
     * 根据ip加载服务器实时详情
     *
     * @param ip IP地址
     * @return
     */
    @RequestMapping(value = "/detail")
    public PMSResult serverDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadServerDetailRealTime(ip);
    }

    /**
     * 根据IP加载服务器内存详情
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/memory")
    public PMSResult memoryDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadMemoryDetailRealTime(ip);
    }

    /**
     * 加载服务器历史数据
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/history")
    public PMSResult serverHistory(@RequestParam(value = "ip") String ip,
                                   @RequestParam(value = "day") String day,
                                   @RequestParam(value = "page", defaultValue = "1") String page,
                                   @RequestParam(value = "pageSize", defaultValue = "10") String pageSize) {
        return serverService.loadServerHistory(ip, day, page, pageSize);
    }

    /**
     * 加载CPU实时信息
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/cpu")
    public PMSResult cpuDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadCPUDetailRealTime(ip);
    }

    /**
     * 分页加载服务器告警信息
     *
     * @param ip
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alarm")
    public PMSResult alarmData(@RequestParam(value = "ip") String ip,
                               @RequestParam(value = "page", defaultValue = "1") String page,
                               @RequestParam(value = "pageSize", defaultValue = "3") String pageSize) {
        return serverService.loadAlarmData(ip, page, pageSize);
    }

    /**
     * 获取服务器硬件信息
     *
     * @return
     */
    @RequestMapping(value = "/hardware")
    public PMSResult hardwareDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadHardwareDetail(ip);
    }

    /**
     * 获取服务器存储信息
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/storage")
    public PMSResult storageDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadStorageDetailRealTime(ip);
    }

    /**
     * 获取服务器各状态详情
     *
     * @param ip
     * @return
     */
    @RequestMapping(value = "/states")
    public PMSResult statesDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadStatesDetailRealTime(ip);
    }
}
