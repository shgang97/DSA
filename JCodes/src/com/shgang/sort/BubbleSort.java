package com.shgang.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {3, 9, -1, 10, -2, 20, 20, 20, 30};
		System.out.println("排序前：" + Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("冒泡排序结果：" + Arrays.toString(arr));


	}

	public static void bubbleSort(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					Exchange.xorExchange(arr, j, j + 1);
				}
			}
//			if (!flag) {
//				break;
//			} else {
//				flag = false;
//			}
//			System.out.println("第" + (i + 1) + "次" + Arrays.toString(arr));
		}
	}

}
