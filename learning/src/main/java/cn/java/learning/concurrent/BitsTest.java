package cn.java.learning.concurrent;

/**
 * 学习ForkJoinPool里的位运算。
 */
public class BitsTest {
    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(0x0001L));
        System.out.println(Long.toBinaryString(0x0001L << 48));
        System.out.println(Long.toBinaryString(0x0001L << 47));
        System.out.println(Long.toBinaryString(0xffffL << 48));
        System.out.println(Long.toBinaryString(4L));
        System.out.println(Long.toBinaryString((long) (-4)));
        System.out.println(Long.toBinaryString(3L));
        System.out.println(Long.toBinaryString((long) (-3)));
        System.out.println(Long.toBinaryString(-844442110001152L));

        System.out.println(Long.toBinaryString(4 & 0xffff));
        System.out.println(Long.toBinaryString(4 & 0xffff & 0xffff));

        System.out.println(0|1);
        System.out.println(1&~1);

        int rs = 5;
        int RLOCK = 1;
        System.out.println(rs|RLOCK);
        System.out.println((rs|RLOCK)&~RLOCK);
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
