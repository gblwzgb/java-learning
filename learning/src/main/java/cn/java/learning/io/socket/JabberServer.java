package cn.java.learning.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l_x_l on 2017-01-21.
 */
public class JabberServer {

    public static int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务端已经启动:" + serverSocket);
            //等待请求，直到获得请求才往下走。
            socket = serverSocket.accept();
            //用于接受客户端发来的请求
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //用于发送返回信息，可以不需要这么多io流，使用缓冲流时发送数据要注意调用.flush()方法
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
                String str = br.readLine();
                if (str.equals("END")) {
                    break;
                }
                System.out.println("Client Socket Message:" + str);
                Thread.sleep(2000);
                pw.println("Message Received");
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Close...");
            try {
                br.close();
                pw.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
