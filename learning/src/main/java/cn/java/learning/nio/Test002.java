package cn.java.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Description: nio的scatter,从一个Channel读取的信息分散到N个缓冲区中(Buufer).
 * Author: lxl
 * Date: 2017/2/15 8:58
 */
public abstract class Test002 {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\首页消息板.sql", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer head = ByteBuffer.allocate(128);   //创建一个HeapByteBuffer对象
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer buf[] = {head, body};
        long byteRead = inChannel.read(buf);  //read into buffer.
        System.out.println("共读取到字节数：" + byteRead);

        head.flip();
        System.out.println("head缓冲区中的数据：" + charset.decode(head));

        body.flip();
        System.out.println("body缓冲区中的数据：" + charset.decode(body));

        aFile.close();
        inChannel.close();
    }
}
