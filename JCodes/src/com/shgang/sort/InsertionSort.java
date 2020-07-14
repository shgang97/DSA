package com.shgang.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = {3, 9, -1, 10, -2, 20, 30};
		System.out.println("排序前：" + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("排序后结果：" + Arrays.toString(arr));
	}

//		public static void insertionSort(int[] arr) {
//		boolean flag;
//		for (int i = 1; i < arr.length; i++) {
//			flag = false;
//			for (int j = i ; j > 0; j--) {
//				if (arr[j] < arr[j - 1]) {
//					flag = true;
//					Exchange.xorExchange(arr, j, j - 1);
//				}
//				if (!flag) {
//					break;
//				}
//			}
////			System.out.println("第" + i + "次排序结果" + Arrays.toString(arr));
//		}
//	}

//	public static void insertionSort(int[] arr) {
//		int j;
//		for (int i = 1; i < arr.length; i++) {
//			j = i;
//			while (j > 0 && arr[j] < arr[j - 1]) {
//				Exchange.xorExchange(arr, j, j - 1);
//				j--;
//			}
////			System.out.println("第" + i + "次排序结果" + Arrays.toString(arr));
//		}
//	}

	public static void insertionSort(int[] arr) {
		int j;
		int value;
		for (int i = 1; i < arr.length; i++) {
			value = arr[i];
			j = i;
			while (j > 0 && value < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = value;
//			System.out.println("第" + i + "次排序结果" + Arrays.toString(arr));
		}
	}
}
