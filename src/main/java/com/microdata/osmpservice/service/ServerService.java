package com.microdata.osmpservice.service;

import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.ServerVO;

import java.util.List;

/**
 * Created by Longder on 2016/8/10.
 */
public interface ServerService {
    /**
     * 加载服务器信息列表
     *
     * @param page 页数
     * @param pageSize 页容量
     * @param category 类别
     * @return
     */
    PMSResult loadServerList(String page, String pageSize, String category);
}
