package cn.java.learning.io;

import java.io.*;

/**
 * 打印流
 * 使用PrintStream进行输出
 */
public class IODemo028 {
    public static void main(String[] args) throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("D:" + File.separator + "Hello028.txt")));
        print.print(true);
        print.println("lxl");   //不用输入\n了。
        print.close();
        //输出结果：truelxl
    }
}


