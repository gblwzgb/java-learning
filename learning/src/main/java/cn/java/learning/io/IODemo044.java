package cn.java.learning.io;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 回退流PushBackInputStream
 */
public class IODemo044 {
    public static void main(String[] args) throws IOException {
        String str = "hello,world";
        ByteArrayInputStream bat = new ByteArrayInputStream(str.getBytes());
        PushbackInputStream push = new PushbackInputStream(bat);
        int temp;
        while ((temp = push.read()) != -1) {
            if (temp == ',') {
                push.unread(temp);  //把值放回去。
                temp = push.read(); //这行去掉就会无限输出
                System.out.print("(回退" + (char) temp + ")");
            } else {
                System.out.print((char) temp);
            }
        }
    }
}
/**
 * 有中文乱码问题。
 */


