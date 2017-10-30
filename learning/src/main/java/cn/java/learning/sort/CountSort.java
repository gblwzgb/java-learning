package cn.java.learning.sort;

/**
 * 计数排序：对桶排序的改进
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = {12, 23, 55, 33, 1, 25, 1, 99, 77, 11};
        countSort(array);
        for (int a : array) {
            System.out.print(a + "  ");
        }
    }

    private static void countSort(int[] arr) {
        int max = maxOfArr(arr);
        int[] bucket = new int[max];   //开辟最大数的空间。如果最大数位10000，则要开10001个。。晕
        for (int a : arr) {
            bucket[a]++;
        }
        int length = arr.length;
        int[] temp = new int[length];
        System.arraycopy(arr, 0, temp, 0, length);
        for (int i = 1; i < max; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = 0; i < length; i++) {
            arr[bucket[temp[i]] - 1] = temp[i];
            bucket[temp[i]]--;
        }
    }

    private static int maxOfArr(int[] arr) {
        int max = arr[0];
        for (int a : arr) {
            if (a > max) {
                max = a + 1;  // 如果最大是2，要准备{0,1,2}的桶，所以要返回3.
            }
        }
        return max;
    }
}
