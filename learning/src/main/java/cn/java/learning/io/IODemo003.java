package cn.java.learning.io;

import java.io.File;
import java.io.IOException;

/**
 * 创建一个新文件，\\用常量表示
 */
public class IODemo003 {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "hell1o.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
