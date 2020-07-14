package com.shgang.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));

	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	/**
	 * 合并的方法
	 *
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;

		//先把左右两边（有序）的数据安装规则填充到temp数组
		//直到左右两边的有序序列，有一边处理完毕位置
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				i++;
				t++;
			} else {
				temp[t] = arr[j];
				j++;
				t++;
			}
		}
		//把有剩余数据的一边的数据全部依次填充到temp
		while (i <= mid) {
			temp[t] = arr[i];
			i++;
			t++;
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		//将temp数组的元素拷贝到arr
		//注意：并不是每次都拷贝所有
		t = 0;
		int tempLeft = left = left;
		//第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
		//最后一次 tempLeft = 0  right = 7
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}
