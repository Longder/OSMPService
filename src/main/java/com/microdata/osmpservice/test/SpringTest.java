package com.microdata.osmpservice.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试Spring容器
 * Created by Longder on 2016/8/5.
 */
public class SpringTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    @Test
    public void testSpring() {
        System.out.println(ac);

    }
}
