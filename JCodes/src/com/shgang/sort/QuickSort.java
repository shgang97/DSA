package com.shgang.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = {2, 5, 3, 1, 10, 7, 8, 6, 10, 11};
		System.out.println("排序前：" + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后结果：" + Arrays.toString(arr));

	}

	public static void quickSort(int[] arr, int left, int right) {
		int lo = left;
		int hi = right;
		int pivot = arr[(lo + hi) / 2];
		while (lo < hi) {
			while (arr[lo] < pivot) {
				lo++;
			}
			while (pivot < arr[hi]) {
				hi--;
			}
			if (lo >= hi) {
				break;
			}
			Exchange.xorExchange(arr, lo, hi);
			if (arr[lo] == pivot) {
				hi--;
//				lo++;
			}
			if (arr[hi] == pivot) {
				lo++;
//				hi--;
			}
		}
		if (lo == hi) {
			lo++;
			hi--;
		}
		if (lo < right) {
			quickSort(arr, lo, right);
		}
		if (left < hi) {
			quickSort(arr, left, hi);
		}
	}
}
