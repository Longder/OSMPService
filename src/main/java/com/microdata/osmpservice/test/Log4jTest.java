package com.microdata.osmpservice.test;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.entity.model.DiskDetailVO;
import com.microdata.osmpservice.entity.socket.HostInfo;
import com.microdata.osmpservice.util.CommonUtil;
import com.microdata.osmpservice.util.SocketConnectionHandler;
import com.microdata.osmpservice.util.SocketUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;


/**
 * Created by Longder on 2016/8/9.
 */
public class Log4jTest {

    public static void main(String[] args) throws Exception {
        //"getDiskInfo"
        Map<String, DiskDetailVO> map = SocketUtil.getDiskDetail("192.168.1.79","");
        System.out.println(map);
    }
}
