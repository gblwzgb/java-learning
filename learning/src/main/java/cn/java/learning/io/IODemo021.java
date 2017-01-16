package cn.java.learning.io;

import java.io.*;

/**
 * 字节流
 * 写文件，不关闭流
 */
public class IODemo021 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello021.txt";
        File f = new File(fileName);
        OutputStream os = new FileOutputStream(f);
        String  str = "测试字节流写的完以后不关闭流。";
        os.write(str.getBytes());
        //out.close();   //可以发现，不关也是可以输出成功的。
    }
}


