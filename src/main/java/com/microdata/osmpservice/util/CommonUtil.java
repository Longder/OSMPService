package com.microdata.osmpservice.util;

import com.microdata.osmpservice.entity.PMSResult;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * 通用工具类
 * Created by Longder on 2016/8/1.
 */
public class CommonUtil {
    private static final int PMS_PORT = 12345;

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
     * 根据指令动态获取主机信息
     *
     * @return
     */
    public static String getHostInfo(String ip, String order) {
        Socket client = null;
        String info = "0";
        try {
            client = new Socket(ip, PMS_PORT);
            final DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF(order);
            DataInputStream in = new DataInputStream(client.getInputStream());
            info = in.readUTF();
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            info = "0";
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    info = "0";
                }
            }
        }
        return info;
    }
}
