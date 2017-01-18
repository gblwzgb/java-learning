package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 乱码的产生
 */
public class IODemo046 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello046.txt");
        OutputStream os = new FileOutputStream(file);
        byte[] bytes = "你好".getBytes("ISO8859-1");
        os.write(bytes);
        os.close();
    }
}


