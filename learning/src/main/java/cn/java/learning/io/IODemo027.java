package cn.java.learning.io;

import java.io.*;

/**
 * 使用管道流。
 * 管道流主要可以进行两个线程之间的通信。
 */
public class IODemo027 {
    public static void main(String[] args) throws IOException {

        Send send = new Send();
        Recive recive = new Recive();

        //管道连接
        send.getPos().connect(recive.getPis());

        new Thread(send).start();
        new Thread(recive).start();

    }
}

/**
 * 消息发送类
 */
class Send implements Runnable {

    private PipedOutputStream pos = null;

    public Send() {
        pos = new PipedOutputStream();
    }

    public PipedOutputStream getPos() {
        return pos;
    }

    public void run() {
        String message = "测试管道流的发送";
        try {
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消息接受类
 */
class Recive implements Runnable {

    private PipedInputStream pis = null;

    public Recive() {
        pis = new PipedInputStream();
    }

    public PipedInputStream getPis() {
        return pis;
    }

    public void run() {
        byte[] b = new byte[100];
        int len = 0;
        try {
            len = pis.read(b);
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接受的内容为:" + new String(b, 0, len));
    }
}


