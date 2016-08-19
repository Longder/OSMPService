package com.microdata.osmpservice.util;

import com.microdata.osmpservice.exception.PMSException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Longder on 2016/8/19.
 */
public class SocketConnectionHandler {
    private static Map<String, Socket> socketPool = new LinkedHashMap<String, Socket>();
    private static Map<String, DataOutputStream> outPool = new LinkedHashMap<String, DataOutputStream>();
    private static Map<String, DataInputStream> inPool = new LinkedHashMap<String, DataInputStream>();

    private static Socket getSocket(String ip) throws Exception {
        if (socketPool.get(ip) == null) {
            //先ping ip
            boolean status = InetAddress.getByName(ip).isReachable(1500);
            if (!status) {
                throw new Exception("ping不通");
            }
            Socket socket = new Socket(ip, SocketUtil.PMS_PORT);
            socketPool.put(ip, socket);
        }
        return socketPool.get(ip);
    }

    private static DataOutputStream getOut(String ip) throws Exception {
        DataOutputStream out;
        if (outPool.get(ip) == null) {
            out = new DataOutputStream(getSocket(ip).getOutputStream());
            outPool.put(ip, out);
        }
        return outPool.get(ip);
    }

    private static DataInputStream getIn(String ip) throws Exception {
        DataInputStream in;
        if (inPool.get(ip) == null) {
            in = new DataInputStream(getSocket(ip).getInputStream());
            inPool.put(ip, in);
        }
        return inPool.get(ip);
    }

    public static String getInfo(String ip, String order) {
        String info = "0";
        DataOutputStream out = null;
        DataInputStream in = null;
        Socket socket = null;
        try {
            boolean status = InetAddress.getByName(ip).isReachable(1500);
            if(!status){
                info = "0";
                throw new PMSException("IP地址无法连接");
            }else{
                socket = new Socket(ip,SocketUtil.PMS_PORT);
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(order);
                in = new DataInputStream(socket.getInputStream());
                info = in.readUTF();
                out.close();
                in.close();
            }
        } catch (Exception e) {
            info = "0";
            throw new PMSException("获取socket连接失败");
        }finally {
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
