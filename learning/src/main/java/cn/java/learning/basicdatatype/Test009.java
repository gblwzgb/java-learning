package cn.java.learning.basicdatatype;

/**
 * final的使用
 */
public class Test009 {
    public static void main(String[] args) {
        final byte b1 = 5, b2 = 5;
        byte b3 = b1 + b2;  //不需要强转
    }
}
