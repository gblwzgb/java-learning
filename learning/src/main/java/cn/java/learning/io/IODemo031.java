package cn.java.learning.io;

import java.io.*;

/**
 * 输入输出重定向
 * 为System.out.println()重定向输出
 */
public class IODemo031 {
    public static void main(String[] args) throws IOException {
        System.out.println("这段输出到控制台");
        File file = new File("D:" + File.separator + "Hello031.txt");
        System.setOut(new PrintStream(new FileOutputStream(file)));
        //System.setOut(new PrintStream(file));  todo:这样也是可以的，想想什么时候要装饰。
        System.out.println("这些要去文件里看。。");
    }
}


