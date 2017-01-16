package cn.java.learning.io;

import java.io.*;

/**
 * 前面的例子都是基于文件的。
 * 这个例子是基于内存的。
 * 也就是在内存中读和写。
 * 使用内存操作流将一个大写字母转化为小写字母
 */
public class IODemo026 {
    public static void main(String[] args) throws IOException {
        String str = "LXL";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int temp;
        while ((temp = bis.read()) != -1) {
            char c = (char) temp;
            bos.write(Character.toLowerCase(c));
        }
        String outstr = bos.toString();
        bis.close();
        bos.close();
        System.out.println(outstr);
    }
}
/**
 * 内容操作流一般使用生成一些临时信息采用的，这样可以避免删除的麻烦。
 */


