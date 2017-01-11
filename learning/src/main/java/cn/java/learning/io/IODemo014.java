package cn.java.learning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流
 * 读取文件内容
 * Demo013改进，因为Demo013会输出很多的空格
 */
public class IODemo014 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        InputStream is = new FileInputStream(f);
        byte[] b = new byte[1024];
        int len = is.read(b);
        is.close();   //和write一样，用完记得关。
        System.out.println("读入长度" + len);
        System.out.println(new String(b, 0, len));
    }
}
/**
 * 注意，如果byte的大小定小了，读取的时候是不会自动扩展的。
 */
