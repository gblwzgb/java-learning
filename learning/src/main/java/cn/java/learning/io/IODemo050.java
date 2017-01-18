package cn.java.learning.io;

import java.io.*;

/**
 * 序列化和反序列化一组对象
 */
public class IODemo050 {
    public static void main(String[] args) throws Exception {
        Object[] objects = {new Person("刘兴龙", 25), new Person("刘兴龙", 25), new Person("刘兴龙", 25)};
        ser(objects); //序列化
        Object[] obj = dser(); //反序列化
        for (Object o : obj) {
            System.out.println(o);
        }
    }

    private static void ser(Object[] objects) throws Exception {
        File file = new File("D:" + File.separator + "Hello050.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(objects);
        oos.close();
    }

    private static Object[] dser() throws Exception {
        File file = new File("D:" + File.separator + "Hello050.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object[] object = (Object[]) ois.readObject();
        ois.close();
        return object;
    }
}


