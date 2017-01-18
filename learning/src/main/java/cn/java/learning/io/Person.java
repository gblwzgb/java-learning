package cn.java.learning.io;

import java.io.Serializable;

/**
 * 实现具有序列化能力的类
 */
public class Person implements Serializable {

    private String name;

    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名:" + name + " 年龄:" + age;
    }
}
