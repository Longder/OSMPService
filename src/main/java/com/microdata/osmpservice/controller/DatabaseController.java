package com.microdata.osmpservice.controller;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.service.database.MysqlService;
import com.microdata.osmpservice.service.database.OracleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Longder on 2016/8/30.
 */
@RestController
@RequestMapping(value = "/database")
public class DatabaseController {
    @Resource(name = "OracleService")
    private OracleService oracleService;
    @Resource(name = "MysqlService")
    private MysqlService mysqlService;

    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public PMSResult loadDatabaseInfo(@RequestParam(value = "ip") String ip, @RequestParam(value = "type") String type) {
        if(type.equalsIgnoreCase("oracle")){
            return oracleService.loadDatabaseInfoRealTime(ip);
        }else if(type.equalsIgnoreCase("mysql")){
            return mysqlService.loadDatabaseInfoRealTime(ip);
        }
        return null;
    }
}
