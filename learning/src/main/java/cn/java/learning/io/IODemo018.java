package cn.java.learning.io;

import java.io.*;

/**
 * 字符流
 * 写入数据
 */
public class IODemo018 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello018.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f);
        String str = "学习使用java字符流中。";
        out.write(str);
        out.close();   //用完记得关。
    }
}
/**
 * 写出的格式应该是和当前项目环境有关的。
 */

