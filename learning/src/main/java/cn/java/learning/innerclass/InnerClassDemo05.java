package cn.java.learning.innerclass;

/**
 * 局部内部类
 */
public class InnerClassDemo05 {
    public static void main(String[] args) {
        new Outer05().printLocalClass(true);
    }
}

class Outer05 {

    private String outerClassName = "Outer05";

    public void printLocalClass(final boolean isPrintOuterClassName) {
        //局部内部类前面不能有任何访问修饰符
        class LocalClass implements Runnable {
            private String localClassName = "localClass";

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    /**
                     * 内部类可以访问外部类域和局部变量，局部变量必须是final类型的
                     */
                    if (isPrintOuterClassName) {
                        System.out.println(outerClassName + " " + localClassName);
                    } else {
                        System.out.println(localClassName);
                    }
                }
            }
        }

        new Thread(new LocalClass()).start();
    }
}
