package cn.java.learning.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 解压缩（只有一个压缩文件的情况）
 */
public class IODemo042 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello040.zip");
        File outFile = new File("D:" + File.separator + "Hello042.txt");
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("Hello031.txt");    //一定要和压缩文件里的名字对应。
        InputStream input = zipFile.getInputStream(entry);
        OutputStream out = new FileOutputStream(outFile);
        int temp;
        while ((temp = input.read()) != -1) {
            out.write(temp);
        }
        input.close();
        out.close();
    }
}


