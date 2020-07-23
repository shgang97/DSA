package com.shgang.algorithm.binarysearch;

public class BinarySearchNoRecur {
	public static void main(String[] args) {
		int[] arr = {1, 3, 8, 10, 11, 67, 100};
		int index = binarySearch(arr, 110);
		System.out.println(index);

	}

	/**
	 * @param arr    待查找待数组
	 * @param target 需要查找待数
	 * @return 返回对应下标，-1表示没有找到
	 */
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (target < arr[mid]) {
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
