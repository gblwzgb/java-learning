package cn.java.learning.sort;

/**
 * 插入排序(从小到大)
 * 插入排序GIF图：![](http://ok7wlv1ee.bkt.clouddn.com/17-10-23/70768985.jpg)
 * https://www.cnblogs.com/hapjin/p/5517667.html
 * 思想：第一位已经排好了，从第二位开始，遍历排好了的序列，找到合适的位置，插入。
 * 复杂度：已经排好的，O(n)，如果刚好倒序，则是O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {4, 3, 6, 5, 8, 2, 12};
        int length = array.length;
        int temp;
        for (int i = 1; i < length; i++) {
            temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
            System.out.print("第一趟：");
            for (int a : array) {
                System.out.print(a + "  ");
            }
            System.out.println();
        }

        for (int a : array) {
            System.out.print(a + "  ");
        }
    }
}
/*
2 3 4 5 3
      j i
temp = array[i]

2 3 4 5 5
    j   i
array[j+1] = array[j];j--

插入必定意味着数字的后移，后移其实就是把前一个数字往后一个数字移的过程。

2 3 4 4 5
  j     i
array[j+1] = array[j];j--

2 3 3 4 5
  j     i
array[j+1] = temp

 */
