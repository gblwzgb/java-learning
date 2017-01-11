package cn.java.learning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流
 * 读取文件内容
 * Demo015改成一个字节一个字节读取
 */
public class IODemo016 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) is.read();
        }
        is.close();   //和write一样，用完记得关。
        System.out.println(new String(b));
    }
}

