package cn.java.learning.io;

import java.io.*;

/**
 * 字符流
 * 写文件，不关闭流
 */
public class IODemo022 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello022.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f);
        String  str = "测试字符流写的完以后不关闭流。";
        out.write(str);
        //out.close();   //可以发现，不关输出失败。
        // 因为字符流是有缓冲区概念的。
        // 可以用out.flush();强制刷新。
    }
}


