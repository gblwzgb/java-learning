package cn.java.learning.io.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by l_x_l on 2017-01-21.
 */
public class JabberClient {

    private static final int PORT = 8080;

    public static final String ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            socket = new Socket(ADDRESS, PORT);
            System.out.println("Socker=" + socket);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            for (int i = 0; i < 10; i++) {
                pw.println("howdy" + i);
                pw.flush();
                //String str = br.readLine();
                //System.out.println(str);
            }
            pw.println("END");
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("close...");
            try {
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
