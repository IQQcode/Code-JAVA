package com.algorithm.quicksort;

import java.util.Arrays;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 10:07
 * @Description:基础快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
        System.out.print("数组元素为：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.print("\n排序结果为：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 左边界基准数
            int key = arr[left];
            int i = left;
            int j = right;
            while (i < j) {
                // j从右向左移动寻找，临界条件为 j == left，已经扫描到最左边了，无需继续扫描
                while (i < j && arr[j] > key) {
                    // 先从右向左找第一个小于key的数
                    j--;
                }
                // 将左右找到的元素进行交换
                if (i < j) {
                    arr[i++] = arr[j];
                }
                // i从左向右移动寻找，临界条件为 i == right，已经扫描到了最右边了，无需继续扫描
                while (i < j && arr[i] < key) {
                    // 再从左向右找第一个大于key的数
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            // 基准数归位
            arr[i] = key;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
