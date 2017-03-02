package cn.java.learning.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 试试可重入的锁
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        new Thread(new ReentrantLockThread("A")).start();
        new Thread(new ReentrantLockThread("B")).start();
        new Thread(new ReentrantLockThread("C")).start();
    }
}

class ReentrantLockThread implements Runnable {

    private String name;

    //可以在构造里指定是否是公平锁，默认是非公平锁
    private static Lock lock = new ReentrantLock();

    public ReentrantLockThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 2; i++) {
                System.out.println("ThreadName = " + name + ", i = " + i);
            }
        } finally {
            lock.unlock();  //切记，不然会阻塞的
        }
    }
}
