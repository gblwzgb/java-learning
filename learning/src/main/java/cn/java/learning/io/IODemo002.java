package cn.java.learning.io;

import java.io.File;

/**
 * File类的两个常量，注意linux和window的区别
 */
public class IODemo002 {
    public static void main(String[] args) {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
}
