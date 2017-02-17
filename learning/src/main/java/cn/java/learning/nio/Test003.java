package cn.java.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Description: nio的gather,将N个buffer收集到一个channel中
 * Author: lxl
 * Date: 2017/2/15 8:58
 */
public abstract class Test003 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\1.sql", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer head = ByteBuffer.allocate(10);   //创建一个HeapByteBuffer对象
        head.put("head".getBytes());
        ByteBuffer body = ByteBuffer.allocate(10);
        body.put("body".getBytes());
        ByteBuffer buf[] = {head, body};

        head.flip();
        body.flip();
        long byteRead = inChannel.write(buf);

        System.out.println("共写入多少字节:" + byteRead);

        aFile.close();
        inChannel.close();
    }
}
