package cn.java.learning.basicdatatype;

/**
 * final的使用
 */
public class Test008 {
    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3;
        b3 = (byte) (b1 + b2);  //需要强转，因为计算结果为int
    }
}
