package cn.java.learning.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用RandomAccessFile写入文件
 * Created by l_x_l on 2017-01-10.
 */
public class IODemo009 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello112.txt";
        File f = new File(fileName);
        RandomAccessFile demo = new RandomAccessFile(f, "rw");

        demo.writeByte(1);
        demo.writeShort(123);
        demo.writeInt(123);
        demo.writeLong(123);
        demo.writeFloat(123.1f);
        demo.writeDouble(123);
        demo.writeBoolean(true);
        demo.writeChar(64);
        demo.writeChar('A');  //不能是这样demo.writeChar("A");

        demo.writeBytes("abcdefg");
    }
}
/**
 * 疑惑一：文件不存在的时候，RandomAccessFile貌似会自己创建文件啊。那为什么还要try/catch住FileNotFoundException?
 *          打断点可以看到是在new RandomAccessFile(f, "rw")的时候创建的文件。
 * 疑惑二：写进去发现好多乱码。
 */
