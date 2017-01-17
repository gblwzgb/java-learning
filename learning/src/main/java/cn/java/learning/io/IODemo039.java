package cn.java.learning.io;

import java.io.*;

/**
 * 合并流SequenceInputStream
 */
public class IODemo039 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:" + File.separator + "Hello031.txt");
        File file2 = new File("D:" + File.separator + "Hello032.txt");
        File file3 = new File("D:" + File.separator + "Hello039.txt");
        InputStream is1 = new FileInputStream(file1);
        InputStream is2 = new FileInputStream(file2);
        OutputStream os = new FileOutputStream(file3);
        //合并流
        SequenceInputStream sis = new SequenceInputStream(is1, is2);
        int temp;
        while ((temp = sis.read()) != -1) {
            os.write(temp);
        }
        is1.close();
        is2.close();
        os.close();
        sis.close();
    }
}


