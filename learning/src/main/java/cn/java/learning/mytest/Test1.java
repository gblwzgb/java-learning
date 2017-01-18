package cn.java.learning.mytest;

/**
 * Created by l_x_l on 2017-01-18.
 */
public class Test1 {
    public static void main(String[] args) {
        Integer i1 = 999;
        Integer i2 = 999;
        System.out.println(i1 == i2);  //false
        Integer i3 = 12;
        Integer i4 = 12;
        System.out.println(i3 == i4);  //true,-128~127用了缓存的.
        Integer i5 = new Integer(9);
        Integer i6 = new Integer(9);
        System.out.println(i5 == i6);  //false
    }


}
