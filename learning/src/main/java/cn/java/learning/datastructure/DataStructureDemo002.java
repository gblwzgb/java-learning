package cn.java.learning.datastructure;

import java.util.Arrays;

/**
 * 数组的比较
 */
public class DataStructureDemo002 {
    public static void main(String[] args) {


        Object[] obj1 = {};
        Object[] obj2 = {};
        System.out.println(obj1 == obj2);  //false，说白了，数组也是对象。

        Object[] obj3 = {};
        Object[] obj4 = {};
        System.out.println(obj3.equals(obj4));  //false，应该有Arrays.equals()

        Object[] obj5 = {};
        Object[] obj6 = {};
        System.out.println(Arrays.equals(obj5, obj6));  //true

    }
}
