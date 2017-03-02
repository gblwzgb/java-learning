package cn.java.learning.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一个空间换时间的工具类：ThreadLocal
 * http://blog.csdn.net/lufeng20/article/details/24314381
 * http://qifuguang.me/2015/09/02/[Java%E5%B9%B6%E5%8F%91%E5%8C%85%E5%AD%A6%E4%B9%A0%E4%B8%83]%E8%A7%A3%E5%AF%86ThreadLocal/
 * 怎么说呢，有时间再看看源码
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        new ThreadLocalThread("A").start();
        new ThreadLocalThread("B").start();
        new ThreadLocalThread("C").start();
    }

}

class Tools {
    //可以有多个ThreadLocal，线程的ThreadLocalMap里的key就是ThreadLocal的引用，而value就是具体的泛型变量的值。
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
}

class ThreadLocalThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger(2);  //初始值为2

    public ThreadLocalThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                Tools.threadLocal.set(ai.getAndAdd(1) + "");
                System.out.println(this.getName() + " getValue---->" + Tools.threadLocal.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

