package cn.java.learning.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符流
 * 写入追加的数据
 */
public class IODemo019 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello018.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f, true);
        String str = "，追加字符流数据。";
        out.write(str);
        out.close();   //用完记得关。
    }
}


