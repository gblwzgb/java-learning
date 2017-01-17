package cn.java.learning.io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Scanner的小例子，从文件中读内容
 */
public class IODemo036 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("D:" + File.separator + "Hello024.txt"));
        //读一个字符串
        String f = in.next();
        System.out.println(f);
    }
}


