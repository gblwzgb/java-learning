package cn.java.learning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流
 * 读取文件内容
 * Demo014改进，因为014设置了1024，万一太大或太小都不好。
 * 小的话是不会自动扩展的，大的话浪费。
 */
public class IODemo015 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        int len = is.read(b);
        is.close();   //和write一样，用完记得关。
        System.out.println("读入长度" + len);
        System.out.println(new String(b, 0, len));
    }
}

