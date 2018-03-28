package deeplearnjvm.part2.p94;

/**
 * VM Args:-XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *          -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 注：PretenureSizeThreshold用于大对象直接在老年代分配（不推荐）
 *      去掉-XX:+UseSerialGC后，Java8的默认垃圾收集器为Parallel Scavenge，此时-XX:PretenureSizeThreshold=3145728是没有作用的。
 *     -XX:PretenureSizeThreshold=3145728只对Serial和ParNew有效。
 *     Parallel Scavenge在新生代内存不够时，也可能会发生大对象直接进入老年代的情况。
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];  //测试大对象直接进入老年代。
    }
}
