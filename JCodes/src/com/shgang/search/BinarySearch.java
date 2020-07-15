package com.shgang.search;

import java.util.ArrayList;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 5, 3, 6, 0};
		System.out.println(binarySearch(arr1, 0, arr1.length - 1, 100));

		int[] arr2 = {1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10};
		ArrayList res = binaryFind(arr2, 0, arr2.length - 1, 3);
		System.out.println(res);
	}

	/**
	 * 二分查找的思路分析
	 * 1. 首先确定该数组的中间的下标
	 * mid = (left + right) / 2
	 * 2. 然后让需要查找的数 findVal 和 arr[mid] 比较
	 * 2. 1 findVal > arr[mid] ,  说明你要查找的数在mid 的右边, 因此需要递归的向右查找
	 * 2.2 findVal < arr[mid], 说明你要查找的数在mid 的左边, 因此需要递归的向左查找
	 * 2.3  findVal == arr[mid] 说明找到，就返回
	 * <p>
	 * //什么时候我们需要结束递归.
	 * 1) 找到就结束递归
	 * 2) 递归完整个数组，仍然没有找到findVal ，也需要结束递归  当 left > right 就需要退出
	 */
	public static int binarySearch(int[] arr, int left, int right, int value) {
		int mid = (left + right) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (left > right) {
			return -1;
		} else {
			if (value < arr[mid]) {
				return binarySearch(arr, left, mid - 1, value);
			} else {
				return binarySearch(arr, mid + 1, right, value);
			}
		}
	}

	/**
	 * 当一个有序数组中，有多个相同的数值时，将所有的数值都查找到
	 * <p>
	 * 思路分析
	 * 1. 在找到mid 索引值，不要马上返回
	 * 2. 向mid 索引值的左边扫描，将所有满足的元素的下标，加入到集合ArrayList
	 * 3. 向mid 索引值的右边扫描，将所有满足的元素的下标，加入到集合ArrayList
	 * 4. 将Arraylist返回
	 */
	public static ArrayList binaryFind(int[] arr, int left, int right, int value) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		int midValue = arr[mid];
		int lo = mid;
		int hi = mid;
		if (value == midValue) {
			ArrayList<Integer> resIndexList = new ArrayList<>();
			resIndexList.add(mid);
			while ((lo > left) && (arr[--lo] == midValue)) {
				resIndexList.add(lo);
			}
			while ((hi < right) && (arr[++hi] == midValue)) {
				resIndexList.add(hi);
			}
			return resIndexList;
		} else if (value < midValue) {
			return binaryFind(arr, left, mid - 1, value);
		} else {
			return binaryFind(arr, mid + 1, right, value);
		}
	}

}
