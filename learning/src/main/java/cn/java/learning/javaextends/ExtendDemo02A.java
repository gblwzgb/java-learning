package cn.java.learning.javaextends;

/**
 * 研究子类构造方法里用super显式和隐式调用父类构造方法的问题。
 */
public class ExtendDemo02A extends ExtendDemo02B {
    public ExtendDemo02A() {
        super();
        System.out.println("子类的无参构造方法");
    }

    public static void main(String[] args) {
        new ExtendDemo02A();
    }

}

class ExtendDemo02B {

    public ExtendDemo02B() {
        System.out.println("父类的无参构造方法");
    }

    public ExtendDemo02B(int i) {
        System.out.println("父类的有参构造方法");
    }
}