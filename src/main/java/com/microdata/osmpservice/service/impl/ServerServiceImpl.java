package com.microdata.osmpservice.service.impl;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.dao.AlarmDataDao;
import com.microdata.osmpservice.dao.HostDao;
import com.microdata.osmpservice.dao.ServerDao;
import com.microdata.osmpservice.dao.ServerDataDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.*;
import com.microdata.osmpservice.entity.po.Host;
import com.microdata.osmpservice.entity.po.ServerData;
import com.microdata.osmpservice.entity.socket.HostInfo;
import com.microdata.osmpservice.exception.PMSException;
import com.microdata.osmpservice.service.ServerService;
import com.microdata.osmpservice.util.CommonUtil;
import com.microdata.osmpservice.util.SocketConnectionHandler;
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
    @Resource
    private ServerDataDao serverDataDao;
    @Resource
    private AlarmDataDao alarmDataDao;

    /**
     * 加载服务器信息列表
     *
     * @param page     页数
     * @param pageSize 页容量
     * @param category 类别
     * @return
     */
    public PMSResult loadServerList(String page, String pageSize, String category) {
        //计算mybatis分页因子
        Map<String, Object> conditionMap = createMybatisPageInfo(page, pageSize);
        //构建查询Map
        conditionMap.put("category", category);
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
        //判断主机的类型来进行获取数据
        HostInfo hostInfo = getHostInfo(ip);
        ServerDetailVO serverDetail = new ServerDetailVO();
        //判断是否获取成功
        if (hostInfo.isFillSuccess()) {
            Map<Integer, String> memoryInfo = SocketUtil.getMemoryDetail(ip);
            //内存剩余容量
            serverDetail.setFreeMemory(memoryInfo.get(SocketUtil.FREE_MEMORY));
            //硬盘剩余容量
            serverDetail.setFreeStorage(SocketUtil.getResidualCapacity(hostInfo.getTotalStorage(), SocketConnectionHandler.getInfo(ip, SocketOrder.GET_STORAGE_TOTAL_PERCENT)));
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
        try {
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
        } catch (PMSException e) {
            pmsResult.setStatus(2);
            pmsResult.setMessage(e.getMessage());
            pmsResult.setData(null);
            e.printStackTrace();
        }
        return pmsResult;
    }

    /**
     * 加载服务器历史数据
     *
     * @param ip
     * @return
     */
    @Override
    public PMSResult loadServerHistory(String ip, String day, String page, String pageSize) {

        //mybatis分页
        Map<String, Object> conditionMap = createMybatisPageInfo(page, pageSize);
        //构建查询条件
        conditionMap.put("ip", ip);
        conditionMap.put("day", day);
        List<ServerData> list = serverDataDao.findByIpAndTime(conditionMap);
        if (list != null && list.size() > 0) {
            pmsResult.setStatus(0);
            pmsResult.setMessage("查询成功");
            ServerDataVO serverDataVO = new ServerDataVO();
            serverDataVO.setServerData(list);
            //处理over标识
            int count = serverDataDao.findCountByIp(conditionMap);
            int totalPage = CommonUtil.getTotalPages(count, Integer.parseInt(pageSize));
            if (totalPage == Integer.parseInt(page)) {
                serverDataVO.setOver(true);
            } else {
                serverDataVO.setOver(false);
            }
            pmsResult.setData(serverDataVO);
        } else {
            pmsResult.setStatus(1);
            pmsResult.setMessage("未查询到数据");
            pmsResult.setData(null);
        }
        return pmsResult;
    }

    /**
     * 根据IP实时加载CPU详情
     *
     * @param ip
     * @return
     */
    @Override
    public PMSResult loadCPUDetailRealTime(String ip) {
        //判断主机的类型来进行获取数据
        HostInfo hostInfo = getHostInfo(ip);
        //判断是否填充成功
        if (hostInfo.isFillSuccess()) {
            CPUDetailVO cpuDetailVO = new CPUDetailVO();
            cpuDetailVO.setModel(hostInfo.getCpuName());
            cpuDetailVO.setFrequency(hostInfo.getCpuFrequency());
            //实时信息
            Double usedRate = SocketUtil.getCPURate(ip);
            Double freeRate = 100 - usedRate;
            cpuDetailVO.setUsedRate(String.valueOf(usedRate));
            cpuDetailVO.setFreeRate(String.valueOf(freeRate));
            pmsResult.setStatus(0);
            pmsResult.setMessage("获取成功");
            pmsResult.setData(cpuDetailVO);
        } else {
            pmsResult.setStatus(2);
            pmsResult.setMessage("此IP下服务器异常");
            pmsResult.setData(null);
        }
        return pmsResult;
    }

    /**
     * 根据ip，分页信息加载服务器告警信息
     *
     * @param ip
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PMSResult loadAlarmData(String ip, String page, String pageSize) {
        //计算mybatis分页因子
        Map<String, Object> conditionMap = createMybatisPageInfo(page, pageSize);
        //构建查询Map
        conditionMap.put("ip", ip);
        List<AlarmDataVO> list = alarmDataDao.findByCondition(conditionMap);
        if (CommonUtil.checkListNullOrEmpty(list)) {
            pmsResult.setStatus(2);
            pmsResult.setMessage("该页没有数据");
            pmsResult.setData(null);
        } else {
            pmsResult.setStatus(0);
            pmsResult.setMessage("查询成功");
            pmsResult.setData(list);
        }
        return pmsResult;
    }

    /**
     * 构建服务器列表集合中的实时信息（status和startDate）
     *
     * @param list
     * @return
     */
    private List<ServerVO> fillRealTimeInfo(List<ServerVO> list) {
        //主机信息
        HostInfo hostInfo = new HostInfo();
        for (ServerVO server : list) {
            try {
                String info = SocketConnectionHandler.getInfo(server.getIp(), SocketOrder.GET_WINDOWS_HOST_INFO);
                hostInfo.initHostInfo(info);
                //处理启动时间
                String workStationInfo = SocketConnectionHandler.getInfo(server.getIp(), SocketOrder.GET_WORK_STATION_INFO);
                if ("0".equals(workStationInfo)) {
                    server.setStatus("0");
                } else {
                    String startTime = workStationInfo.split("<string>")[1];
                    startTime = startTime.substring("统计数据开始于 ".length(), startTime.length());
                    server.setStatus("1");
                    server.setStartTime(startTime);
                }
            } catch (PMSException e) {
                server.setStatus("0");
            }
            //如果获取不到实时信息，状态为0，启动时间为null
        }
        return list;
    }

    /**
     * 根据ip获取主机数据（实时），封装成HostInfo实体
     * 如果获取失败，返回null
     *
     * @param ip
     * @return
     */
    private HostInfo getHostInfo(String ip) {
        //先查询出此ip的主机信息
        Host host = hostDao.findByIp(ip);
        if (host == null) {
            return new HostInfo("0");
        }
        //判断主机的类型来进行获取数据
        HostInfo hostInfo;
        try {
            if ("Windows".equals(host.getCategory())) {
                hostInfo = new HostInfo(SocketConnectionHandler.getInfo(ip, SocketOrder.GET_WINDOWS_HOST_INFO));
            } else if ("Linux".equals(host.getCategory())) {
                hostInfo = new HostInfo(SocketConnectionHandler.getInfo(ip, SocketOrder.GET_LINUX_HOST_INFO));
            } else {
                hostInfo = new HostInfo("0");
            }
        } catch (PMSException e) {
            hostInfo = new HostInfo("0");
        }
        return hostInfo;
    }

    /**
     * 构建mybatis分页因子（start,limit）封装到map中返回
     *
     * @return
     */
    private Map<String, Object> createMybatisPageInfo(String page, String pageSize) {
        //计算mybatis分页因子
        //根据每页显示条数和当前页计算mybatis分页因子
        int start = Integer.parseInt(pageSize) * Integer.parseInt(page) - Integer.parseInt(pageSize);
        int limit = Integer.parseInt(pageSize);
        //构建Map
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("start", start);
        pageMap.put("limit", limit);
        return pageMap;
    }

}
