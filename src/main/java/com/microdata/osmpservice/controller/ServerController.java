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

    @RequestMapping(value = "/list")
    public PMSResult list(@RequestParam(value = "page",defaultValue = "1") String page,
                          @RequestParam(value = "pageSize",defaultValue = "5") String pageSize,
                          @RequestParam(value = "category",defaultValue = "") String category) {
        return serverService.loadServerList(page, pageSize, category);
    }
}
