package deeplearnjvm.p59;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * Desc:不知道为什么我的idea跑这个demo会崩掉。
 */
public class DirectMemoryOOM {
    public static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        for (; ; ) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
