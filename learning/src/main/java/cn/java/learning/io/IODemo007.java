package cn.java.learning.io;

import java.io.File;

/**
 * 判断一个指定的路径是否为目录
 */
public class IODemo007 {
    public static void main(String[] args) {
        File file = new File("G:\\迅雷下载\\嗜血法医第二季");
        if (file.isDirectory()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
