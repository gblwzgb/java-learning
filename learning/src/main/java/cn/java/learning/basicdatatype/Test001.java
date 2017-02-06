package cn.java.learning.basicdatatype;

/**
 * 试验包装类的自增。
 */
public class Test001 {
    private static void add(Byte b) {
        b = b++;
    }

    public static void main(String[] args) {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a);  //-128
        add(b);
        System.out.println(b);  //127
    }
}
