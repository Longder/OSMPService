package com.microdata.osmpservice.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 记录日志的切面组件
 * Created by Longder on 2016/8/9.
 */
@Component
@Aspect
public class LoggerBean {
    private static StringBuilder builder = new StringBuilder();
    private static  Logger logger = LogManager.getLogger(LoggerBean.class);

    @Before("within(com.microdata.osmpservice.controller..*)")
    public void preController(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String info = createLogInfo(targetName, methodName);
        logger.info(info);
        //清空builder
        builder.setLength(0);
    }

    public void afterController() {

    }

    /**
     * 拼接info级日志信息
     *
     * @param targetName 类名
     * @param methodName 方法名
     * @return 拼接好的信息
     */
    private String createLogInfo(String targetName, String methodName) {
        builder.append("Into Method==>");
        builder.append(targetName);
        builder.append(".");
        builder.append(methodName);
        return builder.toString();
    }
}
