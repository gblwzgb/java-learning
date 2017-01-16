package cn.java.learning.io;

import java.io.*;

/**
 * 使用OutputStream向屏幕上输出内容
 */
public class IODemo030 {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        out.write("哈哈哈".getBytes());
        out.close();
    }
}


