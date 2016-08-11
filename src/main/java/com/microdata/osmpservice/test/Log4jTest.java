package com.microdata.osmpservice.test;

import com.microdata.osmpservice.test.dao.Bar;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * Created by Longder on 2016/8/9.
 */
public class Log4jTest {
    private static final Logger logger = LogManager.getLogger(SpringTest.class);

    public static void main(final String... args) {
        logger.trace("Entering application.");
        Bar bar = new Bar();
        if (!bar.doIt()) {
            logger.error("Didn't do it.");
        }
        logger.trace("Exiting application.");
    }
}
