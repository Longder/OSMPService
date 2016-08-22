package com.microdata.osmpservice.util;

import com.microdata.osmpservice.exception.PMSException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Longder on 2016/8/19.
 */
public class SocketConnectionHandler {
    /**
     * 根据ip,socket指令获取信息
     *
     * @param ip
     * @param order
     * @return
     */
    public static String getInfo(String ip, String order) {
        String info = "0";
        DataOutputStream out = null;
        DataInputStream in = null;
        Socket socket = null;
        try {
            boolean status = InetAddress.getByName(ip).isReachable(1500);
            if (!status) {
                info = "0";
                throw new PMSException("此IP下服务器异常");
            } else {
                socket = new Socket(ip, SocketUtil.PMS_PORT);
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(order);
                in = new DataInputStream(socket.getInputStream());
                info = in.readUTF();
                out.close();
                in.close();
            }
        } catch (Exception e) {
            info = "0";
            throw new PMSException("此IP下服务器异常");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return info;
    }
}
