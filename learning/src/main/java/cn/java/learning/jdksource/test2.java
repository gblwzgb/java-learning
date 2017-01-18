package cn.java.learning.jdksource;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: lxl
 * Date: 2017/1/18 11:14
 */
public class test2 {
    static int[] array = new int[100];

    static int MAX_DEEP = 20;

    static {
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        new Thread(new Runnable() {
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                loop(list, 0, 0, 20);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                loop(list, 0, 20, 40);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                loop(list, 0, 40, 60);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                loop(list, 0, 60, 80);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                loop(list, 0, 80, 100);
            }
        }).start();
        System.out.println("花费时间" + (System.currentTimeMillis() - start) + "毫秒");
    }

    private static void loop(List<Integer> list, int deep, int current, int limit) {

        if (deep == 0) {
            for (int i = current; i < limit; i++) {
                if (list.size() == deep) {
                    list.add(deep, array[i]);
                } else {
                    list.set(deep, array[i]);
                }
                if (deep < MAX_DEEP) {
                    loop(list, deep + 1, i + 1, array.length);
                } else {
                    System.out.println(list);
                }
            }
        } else {
            for (int i = current; i < array.length - MAX_DEEP + deep; i++) {
                if (list.size() == deep) {
                    list.add(deep, array[i]);
                } else {
                    list.set(deep, array[i]);
                }
                if (deep < MAX_DEEP) {
                    loop(list, deep + 1, i + 1, array.length);
                } else {
                    System.out.println(list);
                }
            }
        }


    }
}
