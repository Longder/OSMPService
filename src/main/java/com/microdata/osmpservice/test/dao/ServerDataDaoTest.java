package com.microdata.osmpservice.test.dao;

import com.microdata.osmpservice.dao.ServerDataDao;
import com.microdata.osmpservice.entity.po.ServerData;
import com.microdata.osmpservice.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Longder on 2016/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class ServerDataDaoTest {
    @Resource
    private ServerDataDao serverDataDao;

    @Test
    public void test1() {
        String rex = "yyyy-MM-dd";
        //构建查询条件
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("ip", "192.168.1.2");
        conditionMap.put("startDate", CommonUtil.parseSqlDate("2016-07-04", rex));
        conditionMap.put("endDate", CommonUtil.parseSqlDate("2016-07-05", rex));
        List<ServerData> list = serverDataDao.findByIpAndTime(conditionMap);
        System.out.println(list.size());
    }
}
