package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流
 * 使用PrintStream进行输出
 * 并进行格式化
 */
public class IODemo029 {
    public static void main(String[] args) throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("D:" + File.separator + "Hello029.txt")));
        String name = "lxl";
        int age = 25;
        print.printf("姓名:%s，年龄：%d", name, age); //todo:为什么第二个用%x，然后年龄就变成了19
        print.close();
    }
}


