package cn.java.learning.sort;

/**
 * 递归版本的快速排序
 * GIF图：![](http://ok7wlv1ee.bkt.clouddn.com/17-10-23/14221562.jpg)
 * 快速排序核心："基准"（pivot），分区（partition），交换（swap），递归（recursive）。
 * 为什么要先右再左呢？因为6  1  2  7  9的话，会把7换到6左边。。。
 */
public class RecursiveQuickSort {
    public static void main(String[] args) {
        int[] array = {12, 23, 55, 33, 1, 25, 32, 99, 77, 11};
        quickSort(array, 0, array.length - 1);

        for (int a : array) {
            System.out.print(a + "  ");
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int temp;
        if (i > j) {
            return;
        }
        int pivot = array[left];  // 将最左边的数字作为基准数。
        while (i != j) {  // 当i=j时，说明循环完毕，开始递归
            while (array[j] >= pivot && i < j)  // 从后往前找，直到找到小于基准数的下标j
                j--;
            while (array[i] <= pivot && i < j)  // 从前往后找，直到找到大于基准数的下标i
                i++;
            if (i < j) {  // 交换两数的位置
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = pivot;
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}
