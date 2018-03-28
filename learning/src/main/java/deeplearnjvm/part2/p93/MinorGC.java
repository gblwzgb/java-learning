package deeplearnjvm.part2.p93;

/**
 * VM Args:-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Desc：不同的垃圾回收器会有不同的表现。如上述配置，会分配担保至老年代。
 * 解释：加-XX:+UseSerialGC的原因是因为Java8的server模式默认用的是Parallel Scavenge，所以指定一下单线程的垃圾回收器。
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
