package com.microdata.osmpservice.test;

import com.microdata.osmpservice.constant.SocketOrder;
import com.microdata.osmpservice.util.SocketConnectionHandler;
import com.microdata.osmpservice.util.SocketUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Map;


/**
 * Created by Longder on 2016/8/9.
 */
public class Log4jTest {

    private static final Logger logger = LogManager.getLogger(SpringTest.class);
    public static DataOutputStream out = null;
    public static DataInputStream in = null;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.79", 12345);
        String info1 = readInfo(socket, SocketOrder.GET_WINDOWS_HOST_INFO);
        System.out.println(info1);
        String info2 = readInfo(socket, SocketOrder.GET_WINDOWS_HOST_INFO);
        System.out.println(info2);
    }
    public static String readInfo(Socket socket, String order) {
        String info = "0";
        try {
            if (out == null) {
                out = new DataOutputStream(socket.getOutputStream());
            }
            out.writeUTF(order);
            if (in == null) {
                in = new DataInputStream(socket.getInputStream());
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            reader.readLine();
/*            out.close();
            in.close();*/
        } catch (Exception e) {
            e.printStackTrace();
            info = "0";
        }
        return info;
    }
}
