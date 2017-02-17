package cn.java.learning.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by l_x_l on 2017-02-17.
 */
public class NonBlockingSocketClient1 {

    private static final String STR = "Hello World!";
    private static final String REMOTE_IP = "127.0.0.1";
    private static final int THREAD_COUNT = 5;

    private static class NonBlockingSocketThread extends Thread {
        @Override
        public void run() {
            try {
                int port = 1234;
                SocketChannel sc = SocketChannel.open();
                sc.configureBlocking(false);
                sc.connect(new InetSocketAddress(REMOTE_IP, port));
                while (!sc.finishConnect()) {
                    System.out.println("同" + REMOTE_IP + "的连接正在建立，请稍等！");
                    Thread.sleep(10);
                }
                System.out.println("连接已建立，待写入内容至指定ip+端口！时间为" + System.currentTimeMillis());
                String writeStr = STR + this.getName();
                ByteBuffer buffer = ByteBuffer.allocate(writeStr.length());
                buffer.put(writeStr.getBytes());
                buffer.flip();
                sc.write(buffer);
                buffer.clear();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        NonBlockingSocketThread[] nbsts = new NonBlockingSocketThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            nbsts[i] = new NonBlockingSocketThread();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            nbsts[i].start();
        }
        for (int i = 0; i < THREAD_COUNT; i++){
            //nbsts[i].join();
        }
    }
}
