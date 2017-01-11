package cn.java.learning.io;

import java.io.*;

/**
 * 字符流
 * 读取文件
 */
public class IODemo020 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello018.txt";
        File f = new File(fileName);
        Reader in = new FileReader(f);
        char[] c = new char[1024];
        int len = in.read(c);
        System.out.println("文件长度：" + len);
        in.close();   //用完记得关。
        System.out.println(new String(c, 0, len));
    }
}


