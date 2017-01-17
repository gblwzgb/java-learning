package cn.java.learning.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据操作流DataOutputStream
 */
public class IODemo037 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "Hello037.txt");
        char[] ch = {'A', 'B', 'C'};
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        for (char c : ch) {
            out.writeChar(c);
        }
        out.close();
    }
}
/**
 * todo：输出有乱码。why
 */


