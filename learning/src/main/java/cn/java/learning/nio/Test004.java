package cn.java.learning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description: nio的channel之间的传输
 * Author: lxl
 * Date: 2017/2/15 8:58
 */
public abstract class Test004 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\首页消息板.sql", "rw");
        FileChannel sourceChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\1.sql", "rw");
        FileChannel targetChannel = bFile.getChannel();

        targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());  //有个对应的transferTo()方法

        bFile.close();
        targetChannel.close();

        aFile.close();
        sourceChannel.close();
    }
}
