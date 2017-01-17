package cn.java.learning.io;

import java.io.*;

/**
 * 数据操作流DataInputStream读取文件
 */
public class IODemo038 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello037.txt");
        char[] ch = {'A', 'B', 'C'};
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        char[] c = new char[100];
        int count = 0;
        char temp;
        while ((temp = in.readChar()) != 'C') {
            c[count++] = temp;
        }
        System.out.println(new String(c));
        in.close();
    }
}


