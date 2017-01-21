package cn.java.learning.io.socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单socket通信的服务端
 */
public class SimpleServer {

    private static void run() throws Exception {
        ServerSocket socketSv = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            socketSv = new ServerSocket(2999, 10);
            System.out.println("waiting for connection...");
            Socket connection = socketSv.accept();
            System.out.println("connection received:" + connection.getInetAddress().getHostName());
            in = new ObjectInputStream(connection.getInputStream());
            out = new ObjectOutputStream(connection.getOutputStream());
            Object msg;
            do {
                msg = in.readObject();
                System.out.println(msg);
            } while (msg != null);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socketSv != null) {
                socketSv.close();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        run();
    }
}
