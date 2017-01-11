package cn.java.learning.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建一个新文件
 */
public class IODemo001 {
    public static void main(String[] args) {
        File file = new File("D:\\hello.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
