package cn.java.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description: 通过channel和buffer读取文件
 * Author: lxl
 * Date: 2017/2/15 8:58
 */
public abstract class Test001 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\首页消息板.sql", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(10000);   //创建一个HeapByteBuffer对象
        int byteRead = inChannel.read(buf);  //read into buffer.
        buf.put((byte)65);   //手动插入数据
        while (byteRead != -1) {
            System.out.println("Read " + byteRead);
            buf.flip();   //将Buffer从写模式切换到读模式
            while (buf.hasRemaining()) {  //告知在当前位置和限制之间是否有元素。
                System.out.println((char) buf.get());
            }
            buf.clear();  //一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入.compact()方法也可以，不过compact清的是读取过的数据。
            byteRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
