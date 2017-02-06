package cn.java.learning.javaextends;

/**
 * 主要用来测试构造里的super
 */
public class ExtendDemo01A extends ExtendDemo01B {
    public static void main(String[] args) {
        new ExtendDemo01A();
    }
}

class ExtendDemo01B {
    public ExtendDemo01B() {
        System.out.println("ExtendDemo01B的构造方法");
    }
}
