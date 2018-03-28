package cn.java.learning.sort;

/**
 * 冒泡排序（从小到大）
 * 冒泡排序GIF图：![](http://ok7wlv1ee.bkt.clouddn.com/17-10-23/51283307.jpg)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 8, 2, 12};
        int length = array.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {  // 外层循环指定内层循环的次数
            // 内层循环每执行一次，说明已经有一个数字排好了，这时内层比较次数就要少一次
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int a : array) {
            System.out.println(a);
        }
    }
}
