package cn.java.learning.javaextends;

/**
 * 学习一下类的加载顺序
 */
public class A extends B {

    private C c = new C();

    static {
        System.out.println("子类的静态代码块");
    }

    {
        System.out.println("子类的构造代码块");
    }

    public A() {
        super(1);
        System.out.println("子类的无参构造方法");
    }

    public static void main(String[] args) {
        new A();
    }

}

class B {

    private C c = new C();

    static {
        System.out.println("父类的静态代码块");
    }

    {
        System.out.println("父类的构造代码块");
    }

    public B() {
        System.out.println("父类的无参构造方法");
    }

    public B(int i) {
        System.out.println("父类的有参构造方法");
    }
}

class C {
    public C() {
        System.out.println("类C的构造方法");
    }
}
