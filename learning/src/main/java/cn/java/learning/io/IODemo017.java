package cn.java.learning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流
 * 读取文件内容
 * 如果不知道文件大小，则判断是否读到文件的末尾。
 */
public class IODemo017 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp;
        while ((temp = is.read()) != -1) {
            b[count++] = (byte) temp;
        }
        is.close();   //和write一样，用完记得关。
        System.out.println(new String(b));
    }
}

