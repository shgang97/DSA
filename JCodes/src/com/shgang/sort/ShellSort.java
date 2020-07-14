package com.shgang.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			shellSort(arr, gap);
		}
	}

	public static void shellSort(int arr[], int gap) {
		int value;
		int j;
		for (int i = gap; i < arr.length; i++) {
			value = arr[i];
			j = i;
			while (j > gap - 1 && value < arr[j - gap]) {
				arr[j] = arr[j - gap];
				j -= gap;
			}
			arr[j] = value;
//			System.out.println("第" + i + "次排序结果" + Arrays.toString(arr));
		}
	}
}
