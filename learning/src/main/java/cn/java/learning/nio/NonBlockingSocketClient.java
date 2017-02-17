package cn.java.learning.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by l_x_l on 2017-02-17.
 */
public class NonBlockingSocketClient {

    private static final String STR = "Hello World!";
    private static final String REMOTE_IP = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        int port = 1234;
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(REMOTE_IP, port));
        while (!sc.finishConnect()){
            System.out.println("同" + REMOTE_IP+ "的连接正在建立，请稍等！");
            Thread.sleep(10);
        }
        System.out.println("连接已建立，待写入内容至指定ip+端口！时间为" + System.currentTimeMillis());
        ByteBuffer buffer = ByteBuffer.allocate(STR.length());
        buffer.put(STR.getBytes());
        buffer.flip();
        sc.write(buffer);
        buffer.clear();
        sc.close();
    }
}
