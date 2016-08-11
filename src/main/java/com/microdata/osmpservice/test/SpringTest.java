package com.microdata.osmpservice.test;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * 测试Spring容器
 * Created by Longder on 2016/8/5.
 */
public class SpringTest {

    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    private static final Logger logger = LogManager.getLogger(SpringTest.class);
    @Test
    public void testSpring() {
        System.out.println(ac);
    }

    @Test
    public void testLog4j() {
        System.out.println("Hello");
        logger.debug("123");
        System.out.println("World");
    }
    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
