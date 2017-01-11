package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 通过字节流向文件中写入字符串
 * Created by l_x_l on 2017-01-10.
 */
public class IODemo010 {
    public static void main(String[] args) throws IOException{
        String fileName = "D:" + File.separator + "Hello00.txt";
        File f = new File(fileName);
        OutputStream os = new FileOutputStream(f);
        String str = "学习IO中";
        byte[] b = str.getBytes();
        os.write(b);
        os.close();     //写完记得要关闭
    }
}
/**
 * 疑惑点一：还是会在new FileOutputStream(f);的时候创建不存在的文件。为什么还要求捕获FileNotFoundException呢。
 * 疑点二：为什么这个没有乱码，RandomAccessFile有什么不同么。
 */
