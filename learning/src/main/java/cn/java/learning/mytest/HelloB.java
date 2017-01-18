package cn.java.learning.mytest;

/**
 * Created by l_x_l on 2017-01-18.
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB构造方法");
    }

    static {
        System.out.println("HelloB静态代码块");
    }

    public static void main(String[] args) {
        new HelloB();
        /**
         * HelloA静态代码块
         * HelloB静态代码块
         * HelloA构造方法
         * HelloB构造方法
         */
    }
}

class HelloA {
    public HelloA() {
        System.out.println("HelloA构造方法");
    }

    static {
        System.out.println("HelloA静态代码块");
    }
}
