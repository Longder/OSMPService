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

    @RequestMapping(value = "/memory")
    public PMSResult memoryDetail(@RequestParam(value = "ip") String ip) {
        return serverService.loadMemoryDetailRealTime(ip);
    }

    /**
     * 加载服务器历史数据
     * @param ip
     * @return
     */
    @RequestMapping(value = "/history")
    public PMSResult serverHistory(@RequestParam(value = "ip")String ip,
                                   @RequestParam(value = "startDate")String startDate,
                                   @RequestParam(value = "endDate")String endDate) {
        return serverService.loadServerHistory(ip,startDate,endDate);
    }
}
