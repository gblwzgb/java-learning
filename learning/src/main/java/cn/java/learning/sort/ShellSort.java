package cn.java.learning.sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {12, 23, 55, 33, 1, 25, 32, 99, 77, 11};
        int length = array.length;
        int temp;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {  //当gap=1的时候，不就是插入排序吗？
                temp = array[i];
                int j;
                for (j = i - gap; j >= 0 && array[j] > temp; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
        }

        for (int a : array) {
            System.out.print(a + "  ");
        }
    }
}
