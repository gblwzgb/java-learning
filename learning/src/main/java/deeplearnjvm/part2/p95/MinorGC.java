package deeplearnjvm.part2.p95;

/**
 * VM Args:-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * 注：该例子和书上的结果不同。应该是JDK的版本导致的。
 *     加上PrintTenuringDistribution可以看每次GC，MaxTenuringThreshold的阈值，并不是说设个100，他就
 *     一定在100的时候才进入老年代（况且也设不了这么大，就两个字节表示，最多也就15），该值会动态变化的。
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
