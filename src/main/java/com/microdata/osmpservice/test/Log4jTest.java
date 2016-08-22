package com.microdata.osmpservice.test;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.entity.socket.HostInfo;
import com.microdata.osmpservice.util.SocketConnectionHandler;
import com.microdata.osmpservice.util.SocketUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Map;


/**
 * Created by Longder on 2016/8/9.
 */
public class Log4jTest {

    public static void main(String[] args) throws IOException {
        Double info = SocketUtil.getCPURate("192.168.1.87");
        //HostInfo hostInfo = new HostInfo(info);
        System.out.println(100-info);
    }
}
