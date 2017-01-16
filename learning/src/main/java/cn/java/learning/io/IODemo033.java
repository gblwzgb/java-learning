package cn.java.learning.io;

import java.io.*;

/**
 * 输入输出重定向
 * 为System.in重定向
 */
public class IODemo033 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello032.txt");
        if (!file.exists()) {
            System.exit(1);
        } else {
            System.setIn(new FileInputStream(file));
            byte[] b = new byte[100];
            int len = System.in.read(b);
            System.out.println(new String(b, 0, len));
        }
    }
}


