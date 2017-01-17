package cn.java.learning.jdksource;

import java.util.ArrayList;

/**
 * Description:
 * Author: lxl
 * Date: 2017/1/16 14:50
 */
public class test1 {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        //list1.ensureCapacity(10000005);    //想不通为什么设置了反而变慢了。
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list1.add(i);
        }
        System.out.println("指定capacity大小，花费" + (System.currentTimeMillis() - start1) + "毫秒");


        //想不通第二次为什么这么快。https://www.zhihu.com/question/54852975
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //list2.ensureCapacity();
        long start2 = System.currentTimeMillis();
        for (int i = 10000000; i < 20000000; i++) {
            list2.add(i);
        }
        System.out.println("不指定capacity大小，花费" + (System.currentTimeMillis() - start2) + "毫秒");

    }
}
