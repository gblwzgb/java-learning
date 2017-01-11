package cn.java.learning.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 通过字节流向文件中追加新内容
 */
public class IODemo012 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "Hello01.txt";
        File f = new File(fileName);
        OutputStream os = new FileOutputStream(f, true); //true代表append，不写默认false，也就是会重写以前的内容。
        String str = "，学习如何追加新内容";
        byte[] b = str.getBytes();
        for (byte b1 : b) {
            os.write(b1);
        }
        os.close();     //写完记得要关闭
    }
}
/**
 * 源码解读：
 * new FileOutputStream(f)为什么会覆盖，
 * 因为它调用了另一个构造函数new FileOutputStream(f, false);
 * false表示不append，所以覆盖了。
 */
