package com.microdata.osmpservice.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 通用工具类
 * Created by Longder on 2016/8/17.
 */
public class CommonUtil {
    /**
     * 小数格式化工具，默认保留一位小数
     */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("######0.0");

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

    /**
     * 字符串按照格式转java.sql.Date
     *
     * @param value
     * @param rex
     * @return
     */
    public static java.sql.Date parseSqlDate(String value, String rex) {
        SimpleDateFormat format = new SimpleDateFormat(rex);
        java.sql.Date sqlDate = null;
        try {
            Date date = format.parse(value);
            sqlDate = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    /**
     * 计算总页数
     *
     * @param totalNumber 总数
     * @param pageSize    页容量
     * @return 总页数
     */
    public static int getTotalPages(int totalNumber, int pageSize) {
        if (pageSize == 0) {
            return 0;
        }
        int totalPages;
        if (totalNumber % pageSize == 0) {
            totalPages = totalNumber / pageSize;
        } else {
            totalPages = totalNumber / pageSize + 1;
        }
        return totalPages;
    }

    /**
     * 把KB数据转换为GB
     *
     * @param data
     * @return
     */
    public static String convertKBtoGB(String data) {
        return DECIMAL_FORMAT.format(Double.parseDouble(data) / 1024 / 1024) + "G";
    }

    /**
     * 根据总量和分量计算百分比（返回不带百分号）
     *
     * @param member
     * @param total
     * @return
     */
    public static String getPersent(String member, String total) {
        //去掉单位
        if (member.endsWith("G")) {
            member = member.substring(0, member.length() - 1);
        }
        if (total.endsWith("G")) {
            total = total.substring(0, total.length() - 1);
        }
        return DECIMAL_FORMAT.format(Double.parseDouble(member) / Double.parseDouble(total) * 100);
    }
}
