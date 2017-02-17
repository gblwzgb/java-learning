package cn.java.learning.basicdatatype;

/**
 * final的使用
 */
public class Test011 {
    public static void main(String[] args) {
        final byte b1 = 2;
        byte b2 = 3;
        byte b3 = (byte) (b1 + b2);  //需要强转
    }
}
