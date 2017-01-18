package cn.java.learning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream使用
 */
public class IODemo048 {
    public static void main(String[] args) throws Exception {
        File file = new File("D:" + File.separator + "Hello047.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) ois.readObject();
        ois.close();
        System.out.println(person);
    }
}


