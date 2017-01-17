package cn.java.learning.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * Scanner的小例子，从键盘读数据
 */
public class IODemo035 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //读一个整数
        int temp = in.nextInt();
        System.out.println(temp);
        //读一个字符串
        String f = in.nextLine();
        System.out.println(f);
    }
}


