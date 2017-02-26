package cn.java.learning.concurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore被用于控制特定资源在同一个时间被访问的个数。
 */
public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(3);
    private static ExecutorService service = Executors.newFixedThreadPool(6);

    public static void main(String[] args) {
        //执行9个任务
        for (int i = 0; i < 9; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.printf("%s时获取资源，并调用.\n", new Date().toString());
                        //线程挂起3秒
                        TimeUnit.SECONDS.sleep(3);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}
