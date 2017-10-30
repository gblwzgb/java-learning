package cn.java.learning.concurrent;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 百米赛跑的运动员起跑前需要准备，
 * 所有选手准备完毕之后，才可以同时起跑。
 */
public class CyclicBarrierTest {

    private static final Logger LOGGER = Logger.getLogger(CyclicBarrierTest.class);

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
    private static ExecutorService service = Executors.newFixedThreadPool(10);  //一定要比8大，跑道都不够，会堵住的。。

    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            service.execute(new Runner(i, cyclicBarrier));
        }
        service.shutdown();
    }
}

class Runner implements Runnable {

    private int number;
    private CyclicBarrier cyclicBarrier;

    public Runner(int number, CyclicBarrier cyclicBarrier) {
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int timer = new Random().nextInt(5);
        try {
            TimeUnit.SECONDS.sleep(timer);
            System.out.printf("%d号选手准备完毕，用时：%d秒.\n", number, timer);
            cyclicBarrier.await();  //等待其他线程准备完毕
            System.out.printf("%d号选手在%s时起跑.\n", number, new Date().toString());
        } catch (InterruptedException | BrokenBarrierException e) {  //还有这种写法啊.
            e.printStackTrace();
        }
    }
}
