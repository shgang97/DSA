package com.shgang.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {3, 9, -1, 10, -2, 20, 30};
		System.out.println("排序前：" + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("排序后结果：" + Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
		int minIndex;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
//			System.out.println(minIndex);
//			if (min != i) {
//				Exchange.xorExchange(arr, i, min);
//			}
			Exchange.xorExchange(arr, i, minIndex);
//			System.out.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(arr));
		}
	}
}
