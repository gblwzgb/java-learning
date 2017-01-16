package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 输入输出重定向
 * 为System.err.println()重定向输出错误信息
 */
public class IODemo032 {
    public static void main(String[] args) throws IOException {
        System.err.println("这段输出到控制台");   //输出是红色的字体
        File file = new File("D:" + File.separator + "Hello032.txt");
        System.setErr(new PrintStream(new FileOutputStream(file)));
        //System.setErr(new PrintStream(file));  todo:这样也是可以的，想想什么时候要装饰。
        System.err.println("这些要去文件里看的。。");
    }
}


