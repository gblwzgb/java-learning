package cn.java.learning.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的socket服务端
 */
public class MultiJabberServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("socket:" + socket);
                new ServeOneJabber(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ServeOneJabber extends Thread {

    private Socket socket = null;

    private BufferedReader br = null;

    private PrintWriter pw = null;

    public ServeOneJabber(Socket socket) {
        this.socket = socket;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String str;
            try {
                str = br.readLine();
                if (str.equals("END")) {
                    br.close();
                    pw.close();
                    socket.close();
                    break;
                }
                System.out.println("Client Socket Message:" + str);
                pw.println("Message Received");
                pw.flush();
            } catch (Exception e) {
                try {
                    br.close();
                    pw.close();
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
