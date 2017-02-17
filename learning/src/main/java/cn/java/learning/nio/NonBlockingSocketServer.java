package cn.java.learning.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by l_x_l on 2017-02-17.
 */
public class NonBlockingSocketServer {

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocketChannel ssc = ServerSocketChannel.open();  //开启一个socket通道
        ssc.configureBlocking(false);   //设置为非阻塞模式
        ssc.bind(new InetSocketAddress(port));  //下面的绑定形式也可以。
        //ServerSocket ss = ssc.socket();  //获取通道对应的ServerSocket对象
        //ss.bind(new InetSocketAddress(port));  //绑定端口
        System.out.println("开始等待客户端的数据！时间为" + System.currentTimeMillis());
        while (true) {
            SocketChannel sc = ssc.accept();
            if (sc == null) {
                // 如果当前没有数据，等待1秒钟再次轮询是否有数据，在学习了Selector之后此处可以使用Selector
                Thread.sleep(1000);
            } else {
                System.out.println("客户端已有数据到来，客户端ip为:" + sc.socket().getRemoteSocketAddress()
                        + ", 时间为" + System.currentTimeMillis());
                ByteBuffer buffer = ByteBuffer.allocate(100);
                sc.read(buffer);
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                sc.close();
                System.exit(0);
            }
        }
    }
}
