package com.microdata.osmpservice.service.impl;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.dao.HostDao;
import com.microdata.osmpservice.dao.ServerDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.MemoryDetailVO;
import com.microdata.osmpservice.entity.model.ServerDetailVO;
import com.microdata.osmpservice.entity.model.ServerVO;
import com.microdata.osmpservice.entity.po.Host;
import com.microdata.osmpservice.entity.socket.HostInfo;
import com.microdata.osmpservice.exception.PMSException;
import com.microdata.osmpservice.service.ServerService;
import com.microdata.osmpservice.util.CommonUtil;
import com.microdata.osmpservice.util.SocketUtil;
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
    @Resource
    private HostDao hostDao;

    /**
     * 加载服务器信息列表
     *
     * @param page     页数
     * @param pageSize 页容量
     * @param category 类别
     * @return
     */
    public PMSResult loadServerList(String page, String pageSize, String category) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException(e);
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
        //先查询出此ip的主机信息
        Host host = hostDao.findByIp(ip);
        if (host == null) {
            pmsResult.setStatus(1);
            pmsResult.setMessage("此IP没有对应服务器");
            pmsResult.setData(null);
            return pmsResult;
        }
        //判断主机的类型来进行获取数据
        HostInfo hostInfo;
        ServerDetailVO serverDetail = new ServerDetailVO();
        if ("Windows".equals(host.getCategory())) {
            hostInfo = new HostInfo(SocketUtil.getHostInfo(ip, SocketOrder.GET_WINDOWS_HOST_INFO));
        } else if ("Linux".equals(host.getCategory())) {
            hostInfo = new HostInfo(SocketUtil.getHostInfo(ip, SocketOrder.GET_LINUX_HOST_INFO));
        } else {
            hostInfo = new HostInfo("0");
        }
        //判断是否获取成功
        if (hostInfo.isFillSuccess()) {
            Map<Integer, String> memoryInfo = SocketUtil.getMemoryDetail(ip);
            //内存剩余容量
            serverDetail.setFreeMemory(memoryInfo.get(SocketUtil.FREE_MEMORY));
            //硬盘剩余容量
            serverDetail.setFreeStorage(SocketUtil.getResidualCapacity(hostInfo.getTotalStorage(), SocketUtil.getHostInfo(ip, SocketOrder.GET_STORAGE_TOTAL_PERCENT)));
            //CPU实时占用百分比（不带单位）
            serverDetail.setCpuRate(SocketUtil.getCPURate(ip));
            //内存实时占用百分比（不带单位）
            serverDetail.setMemoryRate(memoryInfo.get(SocketUtil.MEMORY_RATE));
            pmsResult.setStatus(0);
            pmsResult.setMessage("查询成功");
            pmsResult.setData(serverDetail);
        } else {
            pmsResult.setStatus(2);
            pmsResult.setMessage("此IP下服务器异常");
            pmsResult.setData(null);
        }
        return pmsResult;
    }

    /**
     * 根据IP实时加载内存详情
     *
     * @param ip
     * @return
     */
    public PMSResult loadMemoryDetailRealTime(String ip) {
        Map<Integer, String> memoryDetail = SocketUtil.getMemoryDetail(ip);
        Map<Integer, String> vMemoryDetail = SocketUtil.getVMemoryDetail(ip);
        MemoryDetailVO detail = new MemoryDetailVO();
        /**
         * 物理内存
         */
        detail.setFreeMemory(memoryDetail.get(SocketUtil.FREE_MEMORY));
        detail.setTotalMemory(memoryDetail.get(SocketUtil.TOTAL_MEMORY));
        detail.setUsedMemory(memoryDetail.get(SocketUtil.USED_MEMORY));
        detail.setMemoryRate(memoryDetail.get(SocketUtil.MEMORY_RATE));
        /**
         * 虚拟内存
         */
        detail.setFreeVMemory(vMemoryDetail.get(SocketUtil.FREE_V_MEMORY));
        detail.setTotalVMemory(vMemoryDetail.get(SocketUtil.TOTAL_V_MEMORY));
        detail.setUsedVMemory(vMemoryDetail.get(SocketUtil.USED_V_MEMORY));
        detail.setVMemoryRate(vMemoryDetail.get(SocketUtil.V_MEMORY_RATE));
        pmsResult.setStatus(0);
        pmsResult.setMessage("获取成功");
        pmsResult.setData(detail);
        return pmsResult;
    }

    /**
     * 构建服务器列表集合中的实时信息（status和startDate）
     *
     * @param list
     * @return
     */
    private List<ServerVO> fillRealTimeInfo(List<ServerVO> list) throws PMSException {
        //主机信息
        HostInfo hostInfo = new HostInfo();
        for (ServerVO server : list) {
            String info = SocketUtil.getHostInfo(server.getIp(), SocketOrder.GET_WINDOWS_HOST_INFO);
            //如果获取不到实时信息，状态为0，启动时间为null
            if ("0".equals(info)) {
                server.setStatus("0");
            } else {
                hostInfo.initHostInfo(info);
                //处理启动时间
                String workStationInfo = SocketUtil.getHostInfo(server.getIp(), SocketOrder.GET_WORK_STATION_INFO);
                if ("0".equals(workStationInfo)) {
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
