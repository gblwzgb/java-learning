package cn.java.learning.concurrent;

import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 设想有这样一个功能需要Thread1、Thread2、Thread3、Thread4四条线程
 * 分别统计C、D、E、F四个盘的大小，所有线程都统计完毕交给主线程去做汇总，
 * 利用CountDownLatch来完成就非常轻松。
 */
public class CountDownLatchTest {

    private static CountDownLatch count = new CountDownLatch(4);
    private static ExecutorService service = Executors.newFixedThreadPool(6);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    int timer = new Random().nextInt(10);
                    //模拟耗时任务
                    try {
                        //相比于Thread.sleep()，这个方法可纳秒，微秒，毫秒，秒，分钟，小时，天
                        TimeUnit.SECONDS.sleep(timer);   //可以学习一下这个枚举类。
                        System.out.printf("%s时完成磁盘的统计任务，耗时%d秒.\n", new Date().toString(), timer);
                        //任务完成，计数器减一
                        count.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        //主线程阻塞在这里，直到count被减到0
        count.await();

        System.out.printf("%s时任务全部完成，执行合并运算.\n", new Date().toString());
        service.shutdown();
    }
}
