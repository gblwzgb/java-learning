package cn.java.learning.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用缓冲区从键盘上读取内容
 */
public class IODemo034 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("请输入内容");
        str = buf.readLine();
        System.out.println("你输入的内容是：" + str);
    }
}
/**
 * BufferedReader只能接受字符流的缓冲区，因为每一个中文需要占据两个字节
 * 所以需要将System.in这个字节输入流变成字符输入流。
 */


