package cn.java.learning.innerclass;

/**
 * 匿名内部类
 */
public class InnerClassDemo06 {
    public static void main(String[] args) {
        new Thread(){
            {
                System.out.println(222);
            }

            @Override
            public void run() {
                get();
            }

            private void get(){
                System.out.println(111);
            }
        }.start();
    }
}
