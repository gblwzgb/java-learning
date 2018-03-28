package concurrentprogram.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by l_x_l on 2018-02-13.
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            try {
                lock.lock();
                condition.signal();
            } finally {
                lock.unlock();
            }

        }).start();
    }
}
