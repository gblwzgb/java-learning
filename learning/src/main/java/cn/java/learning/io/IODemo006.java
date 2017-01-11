package cn.java.learning.io;

import java.io.File;

/**
 * 递归打印目录及子目录下的所有内容
 */
public class IODemo006 {
    public static void main(String[] args) {
        File file = new File("G:" + File.separator + "迅雷下载");
        print(file);
    }

    private static void print(File file) {
        if (file != null) {
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (File s : list) {
                    print(s);
                }
            }
        }
    }
}
