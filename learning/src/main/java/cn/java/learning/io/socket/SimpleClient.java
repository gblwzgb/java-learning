package cn.java.learning.io.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 简单socket通信的客户端,会报错：http://men4661273.iteye.com/blog/1646675
 */
public class SimpleClient {

    private static void run() {
        Socket socket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            socket = new Socket("127.0.0.1", 2999);
            System.out.println("connect to localhost:2999");
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();

            out.writeObject("再见");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
