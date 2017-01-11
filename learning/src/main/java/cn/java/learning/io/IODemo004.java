package cn.java.learning.io;

import java.io.File;

/**
 * 删除一个文件
 */
public class IODemo004 {

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "hell1o.txt");
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("文件不存在");
        }
    }
}
