package com.microdata.osmpservice.util;

/**
 * 通用工具类
 * Created by Longder on 2016/8/1.
 */
public class CommonUtil {
    /**
     * 验证字符串为空或者空串
     * @param info 字符串数据
     * @return
     */
    public static boolean checkStringNullOrEmpty(String info){
        if(info==null||"".equals(info)){
            return true;
        }else{
            return false;
        }
    }
}
