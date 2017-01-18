package cn.java.learning.mytest;

/**
 * Created by l_x_l on 2017-01-18.
 */
public class Test2 {


    public static Test2 t1 = new Test2();
    public static Test2 t2 = new Test2();

    public Test2() {
        System.out.println("构造方法");
    }

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }


    public static void main(String[] args) {
        new Test2();  //new的时候会先执行构造块，再执行构造方法.
    }
}
