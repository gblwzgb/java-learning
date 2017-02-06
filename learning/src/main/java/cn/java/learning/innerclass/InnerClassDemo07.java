package cn.java.learning.innerclass;

/**
 * 静态内部类
 */
public class InnerClassDemo07 {
    public static void main(String[] args) {
        Outer07.Inner07 inner07 = new Outer07.Inner07();
    }
}

class Outer07 {

    static class Inner07 {
        public Inner07() {
            System.out.println("init");
        }
    }
}
