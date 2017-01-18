package cn.java.learning.io;

import java.io.IOException;

/**
 * 取得本地的默认编码
 */
public class IODemo045 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
    }
}


