package com.microdata.osmpservice.test.dao;

import com.microdata.osmpservice.dao.ServerDao;
import com.microdata.osmpservice.entity.model.ServerVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Longder on 2016/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/spring-mvc.xml"})
public class ServerDaoTest {
    @Resource
    private ServerDao serverDao;

    @Test
    public void testFindByCondition() {
        List<ServerVO> list = serverDao.findByCondition(null);
        System.out.println(list.size());
    }
}
