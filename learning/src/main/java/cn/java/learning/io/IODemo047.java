package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream的使用
 */
public class IODemo047 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello047.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Person("刘兴龙", 25));
        oos.close();
    }
}
/**
 * 输出的是二进制文件，是不能直接查看的
 */


