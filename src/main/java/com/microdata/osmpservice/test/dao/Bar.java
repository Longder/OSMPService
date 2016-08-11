package com.microdata.osmpservice.test.dao;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Longder on 2016/8/9.
 */
public class Bar {
    static final Logger logger = LogManager.getLogger(Bar.class.getName());

    public boolean doIt() {
        logger.trace("doIt");
        logger.error("Did it again!");
        return false;
    }
}
