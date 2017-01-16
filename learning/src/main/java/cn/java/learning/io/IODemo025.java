package cn.java.learning.io;

import java.io.*;

/**
 * 将字节输入流变成字符输入流
 */
public class IODemo025 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello024.txt";
        File f = new File(fileName);
        Reader in = new InputStreamReader(new FileInputStream(f));
        char[] c = new char[100];
        in.read(c);
        System.out.println(new String(c));
        in.close();
    }
}


