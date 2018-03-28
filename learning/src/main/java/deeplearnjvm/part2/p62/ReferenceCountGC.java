package deeplearnjvm.part2.p62;

/**
 * VM Args:-XX:+PrintGCDetails
 * Desc：从GC日志可以看出，使用的根搜索算法，而不是引用计数法。
 */
public class ReferenceCountGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountGC objA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}
