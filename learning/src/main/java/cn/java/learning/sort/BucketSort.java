package cn.java.learning.sort;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] array = {12, 23, 55, 33, 1, 25, 32, 99, 77, 11};
        bucketSort(array);
        for (int a : array) {
            System.out.print(a + "  ");
        }
    }

    private static void bucketSort(int[] arr) {
        int max = maxOfArr(arr);
        int[] bucket = new int[max];   //开辟最大数的空间。如果最大数位10000，则要开10001个。。晕
        for (int a : arr) {
            bucket[a]++;
        }
        for (int i = 0, j = 0; i < max; i++) {
            while (bucket[i]-- > 0) {
                arr[j++] = i;
            }
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
