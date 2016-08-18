package com.microdata.osmpservice.test;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.util.SocketUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;


/**
 * Created by Longder on 2016/8/9.
 */
public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(SpringTest.class);

    public static void main(final String... args) {
/*        logger.trace("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.trace("Exiting application.");*/
        String info = SocketUtil.getHostInfo("192.168.1.87",SocketOrder.GET_V_MEMORY_PERCENT);
        //HostInfo host = new HostInfo(info);
        System.out.println(info);
    }
}
