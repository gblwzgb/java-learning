package cn.java.learning.io;

import java.io.*;

/**
 * 将字节输出转化为字符输出流
 */
public class IODemo024 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello024.txt";
        File f = new File(fileName);
        Writer out = new OutputStreamWriter(new FileOutputStream(f));
        out.write("你好，hello024");
        out.close();
    }
}
/**
 * TODO:想想转来转去的意义在哪里
 */


