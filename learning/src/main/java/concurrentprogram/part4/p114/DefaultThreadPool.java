package concurrentprogram.part4.p114;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池默认实现
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    // 线程池最大限制
    private static final int MAX_WORKER_NUMBERS = 10;
    // 线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;
    // 这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<>();
    // 工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    // 工作线程的数量
    private int workNum = DEFAULT_WORKER_NUMBERS;
    // 线程编号生成
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(num);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            // 添加一个工作，然后进行通知
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {  // 这里为什么要加锁？
            if (num + this.workNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workNum;
            }
            initializeWorkers(num);
            workNum += num;
        }
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs) {
            if (num >= workNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            // 按照给定的数量停止Worker
            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            workNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    // 初始化线程工作者
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    // 工作者，负责工作
    class Worker implements Runnable {
        // 是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job;
                synchronized (jobs) {
                    // 如果没有工作，则wait
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        // 忽略Job执行中的Exception
                    }
                }
            }
        }

        public void shutdown() {
            this.running = false;
        }
    }
}
