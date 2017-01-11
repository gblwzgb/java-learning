package cn.java.learning.io;

import java.io.File;

/**
 * 创建一个文件夹
 */
public class IODemo005 {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "hello");
        file.mkdir();
    }
    /**
     * 创建单目录mkdir():创建路径D:/a/b/c，如果a/b不存在，则创建失败
     * 创建多目录mkdirs():创建路径D:/a/b/c，如果a/b不存在，则会创建文件夹a、b、c
     */
}
