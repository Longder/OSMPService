package com.microdata.osmpservice.service.impl;

import com.microdata.osmpservice.dao.ServerDao;
import com.microdata.osmpservice.entity.PMSResult;
import com.microdata.osmpservice.entity.model.ServerVO;
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
        }else{
            pmsResult.setStatus(0);
            pmsResult.setMessage("查询成功");
            pmsResult.setData(serverVOList);
        }
        return pmsResult;
    }
}
