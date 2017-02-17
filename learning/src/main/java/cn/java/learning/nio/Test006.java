package cn.java.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 写文件
 */
public class Test006 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\l_x_l\\Desktop\\11.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String str = "abcd";
        buffer.put(str.getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        channel.close();
        file.close();
    }

}
