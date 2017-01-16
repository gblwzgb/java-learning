package cn.java.learning.io;

import java.io.*;

/**
 * 文件的复制(还以为有封装好的方法呢)
 * TODO:用NIO试试。
 */
public class IODemo023 {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("命令行参数有误，请检查");
            System.exit(1);
        }

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        if (!file1.exists()) {
            System.out.println("被复制的文件不存在，请检查");
            System.exit(1);
        }

        InputStream is = new FileInputStream(file1);
        OutputStream os = new FileOutputStream(file2);

        int temp;
        while ((temp = is.read()) != -1) {
            os.write(temp);
        }

        is.close();
        os.close();
    }
}


