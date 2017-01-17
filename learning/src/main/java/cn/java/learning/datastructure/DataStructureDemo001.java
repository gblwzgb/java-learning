package cn.java.learning.datastructure;

import java.util.Arrays;

/**
 * 数组的复制
 */
public class DataStructureDemo001 {
    public static void main(String[] args) {


        Object[] obj1 = {1};
        Object[] obj2 = Arrays.copyOf(obj1, 10);
        System.out.println(obj1.length);    //1
        System.out.println(obj2.length);    //10
        System.out.println(obj1[0]);    //1
        System.out.println(obj2[8]);    //null

    }
}
