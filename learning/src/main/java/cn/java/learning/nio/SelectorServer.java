package cn.java.learning.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 用NonBlockingSocketClient1当客户端
 */
public class SelectorServer {
    private static int PORT = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(PORT));
        ssc.configureBlocking(false);
        //打开一个选择器
        Selector selector = Selector.open();
        //将ServerSocketChannel注册到选择器上并监听accept事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //这里会发生阻塞，等待就绪的通道
            int n = selector.select();
            //没有就绪的通道则什么也不做
            if (n == 0) {
                continue;
            }
            //获取SelectionKey上已经就绪的通道的集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //遍历每一个key
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                //通道上是否有可接受的连接
                if (sk.isAcceptable()) {
                    ServerSocketChannel ssc1 = (ServerSocketChannel) sk.channel();
                    SocketChannel sc = ssc1.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                }
                //通道上是否有数据可读
                else if (sk.isReadable()) {
                    readDataFromSocket(sk);
                }
                iterator.remove();  //这行去掉会导致41行空指针。
            }
        }
    }

    private static ByteBuffer bb = ByteBuffer.allocate(2);

    //从通道中读取数据
    private static void readDataFromSocket(SelectionKey sk) throws Exception {
        SocketChannel sc = (SocketChannel) sk.channel();
        bb.clear();
        while (sc.read(bb) > 0) {  //一直到数据读完为止
            bb.flip();
            while (bb.hasRemaining()) {
                System.out.print((char) bb.get());
            }
            System.out.println();
            bb.clear();
        }
    }
}
