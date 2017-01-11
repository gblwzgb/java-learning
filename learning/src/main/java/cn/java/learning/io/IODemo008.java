package cn.java.learning.io;

import java.io.File;

/**
 * 列出指定目录的所有文件（包括隐藏文件）
 */
public class IODemo008 {
    public static void main(String[] args) {
        File file = new File("G:" + File.separator + "迅雷下载");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
    /**
     * 列出的是当前目录下的，如果要深入的话。则要自己写个递归。
     */

    /**
     * 用file.list()得到的路径没有带上完整路径，如果要完整路径。
     * 则使用File[] list = file.listFiles();
     * System.out.println(list[i]);
     */
}
