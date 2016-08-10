package com.microdata.osmpservice.util;

import com.microdata.osmpservice.entity.PMSResult;

import java.util.List;

/**
 * 通用工具类
 * Created by Longder on 2016/8/1.
 */
public class CommonUtil {
    /**
     * 验证字符串为空或者空串
     *
     * @param info 字符串数据
     * @return
     */
    public static boolean checkStringNullOrEmpty(String info) {
        if (info == null || "".equals(info)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证集合是null或者为空
     *
     * @param list
     * @return
     */
    public static boolean checkListNullOrEmpty(List list) {
        return list == null || list.size() == 0;
    }

}
