package cn.java.learning.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Externalizable接口的使用
 */
public class Person2 implements Externalizable {

    private String name;

    private int age;

    //用了Externalizable就必须要有一个显式的无参构造，不然反序列话的时候报错。
    public Person2() {

    }

    public Person2(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名:" + name + " 年龄:" + age;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(this.age);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }
}
