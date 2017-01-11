package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 通过字节流向文件中写入字符串，不同于Demo010，采用一个字节一个字节的输出
 */
public class IODemo011 {
    public static void main(String[] args) throws IOException{
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        OutputStream os = new FileOutputStream(f);
        String str = "学习IO字节流中";
        byte[] b = str.getBytes();
        for (byte b1 : b) {
            os.write(b1);
        }
        os.close();     //写完记得要关闭
    }
}
/**
 * 疑惑点一：还是会在new FileOutputStream(f);的时候创建不存在的文件。为什么还要求捕获FileNotFoundException呢。
 * 疑点二：为什么这个没有乱码，RandomAccessFile有什么不同么。
 */
/**
 * 注意点：重复执行，会先清空之前的内容，然后再写入内容。
 */
/**
 * 有意思的地方：打个断点，输入一个字符就刷新一下文件内容，会发现前面一直是中文乱码，最后执行完了的刷新会变正常中文。
 */
