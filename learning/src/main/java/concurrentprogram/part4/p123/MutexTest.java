package concurrentprogram.part4.p123;

import concurrentprogram.part4.p114.ThreadPool;

/**
 * Created by l_x_l on 2018-01-24.
 */
public class MutexTest {
    public static void main(String[] args) throws Exception{
        Mutex mutex = new Mutex();
        new Thread(()->{
            mutex.lock();
            System.out.println(1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutex.unlock();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            mutex.lock();
            System.out.println(2);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mutex.unlock();
        }).start();

    }
}
