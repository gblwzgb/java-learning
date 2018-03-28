package concurrentprogram.part4;

import java.util.concurrent.*;

/**
 * Created by l_x_l on 2018-03-03.
 */
public class Test3 {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future future = executor.submit(() -> System.out.println(1),5);
        System.out.println(future.get());
        Runnable runnableFuture = new FutureTask(()->{
            System.out.println(1);
        },1);

    }
}
