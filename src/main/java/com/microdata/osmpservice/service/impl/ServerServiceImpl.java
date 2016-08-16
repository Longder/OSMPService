package com.microdata.osmpservice.service.impl;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.dao.ServerDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.ServerVO;
import com.microdata.osmpservice.entity.socket.HostInfo;
import com.microdata.osmpservice.service.ServerService;
import com.microdata.osmpservice.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Longder on 2016/8/10.
 */
@Service
public class ServerServiceImpl implements ServerService {
    @Resource
    private PMSResult pmsResult;
    @Resource
    private ServerDao serverDao;

    /**
     * 加载服务器信息列表
     *
     * @param page     页数
     * @param pageSize 页容量
     * @param category 类别
     * @return
     */
    public PMSResult loadServerList(String page, String pageSize, String category) {
        if (StringUtils.isEmpty(page) || StringUtils.isEmpty(pageSize)) {
            pmsResult.setStatus(1);
            pmsResult.setMessage("分页参数有误");
            pmsResult.setData(null);
            return pmsResult;
        }
        //计算mybatis分页因子
        //根据每页显示条数和当前页计算mybatis分页因子
        int start = Integer.parseInt(pageSize) * Integer.parseInt(page) - Integer.parseInt(pageSize);
        int limit = Integer.parseInt(pageSize);
        //构建查询Map
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("category", category);
        conditionMap.put("start", start);
        conditionMap.put("limit", limit);
        List<ServerVO> serverVOList = serverDao.findByCondition(conditionMap);
        if (CommonUtil.checkListNullOrEmpty(serverVOList)) {
            pmsResult.setStatus(2);
            pmsResult.setMessage("该页没有数据");
            pmsResult.setData(null);
        } else {
            //构建状态和启动时间数据
            serverVOList = fillRealTimeInfo(serverVOList);
            pmsResult.setStatus(0);
            pmsResult.setMessage("查询成功");
            pmsResult.setData(serverVOList);
        }
        return pmsResult;
    }

    /**
     * 根据IP实时加载服务器详情
     *
     * @param ip ip地址
     * @return
     */
    public PMSResult loadServerDetailRealTime(String ip) {

        return null;
    }

    /**
     * 构建服务器列表中的实时信息（status和startDate）
     *
     * @param list
     * @return
     */
    private List<ServerVO> fillRealTimeInfo(List<ServerVO> list) {
        //主机信息
        HostInfo hostInfo = new HostInfo();
        for (ServerVO server : list) {
            String info = CommonUtil.getHostInfo(server.getIp(), SocketOrder.GET_WINDOWS_HOST_INFO);
            //如果获取不到实时信息，状态为0，启动时间为null
            if ("0".equals(info)) {
                server.setStatus("0");
            } else {
                hostInfo.initHostInfo(info);
                //处理启动时间
                String workStationInfo = CommonUtil.getHostInfo(server.getIp(), SocketOrder.GET_WORK_STATION_INFO);
                if ("1".equals(workStationInfo)) {
                    server.setStatus("0");
                } else {
                    String startTime = workStationInfo.split("<string>")[1];
                    startTime = startTime.substring("统计数据开始于 ".length(), startTime.length());
                    server.setStatus("1");
                    server.setStartTime(startTime);
                }
            }
        }
        return list;
    }
}
