package concurrentprogram.part4.p194;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 银行流水处理服务类
 * (这个进程结束不了，因为线程池里有4个线程都阻塞在了获取task的代码。)
 * (用Visual VM查看，可以看到那4个线程池里的线程，但是看不到main的线程，因为已经执行结束了。)
 * (可以在main方法里关闭线程池，不过Executor接口没有提供shutdown方法)
 */
public class BankWaterService implements Runnable {
    // 创建4个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier c = new CyclicBarrier(4, this);
    // 假设只有4个sheet，所以只启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);
    // 保存每个sheet计算出的银流结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                // 计算当前sheet的银流数据，计算代码省略
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                // 银流计算完成，插入一个屏障
                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
                System.out.println(Thread.currentThread());
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        // 将结果输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) throws InterruptedException {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}
