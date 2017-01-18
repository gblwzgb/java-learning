package cn.java.learning.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 一次性压缩多个文件
 */
public class IODemo041 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "HelloJava");
        File zipFile = new File("D:" + File.separator + "Hello041.zip");
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        //设置注释
        zipOut.setComment("压缩zip");

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                input = new FileInputStream(file1);
                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + file1.getName()));
                int temp;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }
}


