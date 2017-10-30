package cn.java.learning.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {12, 23, 55, 33, 1, 25, 32, 99, 77, 11};
        int length = array.length;
        int[] temp = new int[length];
        sort(array, 0, array.length - 1, temp);
        for (int a : array) {
            System.out.print(a + "  ");
        }
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0;  //临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {  //将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) { //将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) { //将temp中的元素全部拷贝到原数组中
            arr[left++] = temp[t++];
        }
    }
}
