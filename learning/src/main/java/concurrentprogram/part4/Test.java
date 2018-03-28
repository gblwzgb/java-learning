package concurrentprogram.part4;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by l_x_l on 2018-01-28.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(Integer.numberOfLeadingZeros(-2));
//        System.out.println(Integer.toBinaryString(32));
//        System.out.println(Integer.toBinaryString(1<<15));
//        System.out.println(Integer.toBinaryString(Integer.numberOfLeadingZeros(16) | (1 << (16 - 1))));
//        System.out.println(Integer.toBinaryString((Integer.numberOfLeadingZeros(16) | (1 << (16 - 1))<<16)));
//        System.out.println(Integer.toBinaryString((Integer.numberOfLeadingZeros(16) | (1 << (16 - 1))<<16)+2));
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println((512>>>3)/4);
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        Executor executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<5;i++){
            executor.execute(()->{
                while (true){
                    map.put(UUID.randomUUID().toString(),"1");
                }
            });
        }
    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }
}
