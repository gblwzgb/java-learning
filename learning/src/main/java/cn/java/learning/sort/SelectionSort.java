package cn.java.learning.sort;

/**
 * 选择排序(从小到大)
 * 选择排序动图：![](http://ok7wlv1ee.bkt.clouddn.com/17-10-20/49138857.jpg)
 * 选择排序核心思想：
 *      从未排好的部分的第一个作为最小（最大）的，
 *      然后依次和剩余的比较，如果有更小（更大）的，
 *      记下下标，以此作为新的最小（最大）值，继续比较，一趟结束后，然后和第一个进行交换。
 * 不稳定排序，时间复杂度最好和最坏都和冒泡一样。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 5, 1};
        //version1(array);
        version2(array);//在版本一上进行的优化。
    }

    private static void version1(int[] array) {
        int temp;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int a : array) {
            System.out.println(a);
        }
    }

    //比版本一少了很多次的交换过程。
    private static void version2(int[] array) {
        int temp;
        int length = array.length;
        int minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

        for (int a : array) {
            System.out.println(a);
        }
    }
}

