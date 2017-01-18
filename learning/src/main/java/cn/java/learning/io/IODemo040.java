package cn.java.learning.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件压缩类ZipOutputStream
 */
public class IODemo040 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello031.txt");
        File zipFile = new File("D:" + File.separator + "Hello040.zip");
        InputStream input = new FileInputStream(file);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        //设置注释
        zipOut.setComment("压缩zip");
        int temp;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        input.close();
        zipOut.close();
    }
}
/**
 * 注释有乱码，压缩的文件内容没有。
 */


