package cn.java.learning.io;

import java.io.*;

/**
 * Externalizable接口的使用
 * (也可以直接在实现Serializable的类里不想序列化的属性加上关键字:transient)
 */
public class IODemo049 {
    public static void main(String[] args) throws Exception {
        ser(); //序列化
        dser(); //反序列化
    }

    private static void ser() throws Exception {
        File file = new File("D:" + File.separator + "Hello049.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Person2("刘兴龙", 25));
        oos.close();
    }

    private static void dser() throws Exception {
        File file = new File("D:" + File.separator + "Hello049.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person2 person = (Person2) ois.readObject();
        ois.close();
        System.out.println(person);
    }
}


