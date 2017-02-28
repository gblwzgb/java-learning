package cn.java.learning.concurrent;

/**
 * 写一个死锁
 * 两个线程，你想要的锁在我手里，我想要的锁在你手里
 * 然后就造成了死锁，大家傻呆呆的相互等待。
 *
 * 解决方法：
 * 1、尽量不要在持有一个锁的情况下去获取另外一个锁。
 * 2、用可以设置时间的锁，如ReentrantLock
 */
public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new DeadThread1(deadLock)).start();
        new Thread(new DeadThread2(deadLock)).start();
    }
}

class DeadLock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() throws Exception {
        synchronized (left) {
            Thread.sleep(2000);
            synchronized (right) {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception {
        synchronized (right) {
            Thread.sleep(2000);
            synchronized (left) {
                System.out.println("rightLeft end!");
            }
        }
    }
}

class DeadThread1 implements Runnable {

    private DeadLock deadLock;

    public DeadThread1(DeadLock lock) {
        this.deadLock = lock;
    }

    @Override
    public void run() {
        try {
            deadLock.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DeadThread2 implements Runnable {

    private DeadLock deadLock;

    public DeadThread2(DeadLock lock) {
        this.deadLock = lock;
    }

    @Override
    public void run() {
        try {
            deadLock.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
