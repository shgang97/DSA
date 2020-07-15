package com.shgang.search;

public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10};
		System.out.println(insertValueSearch(arr, 0, arr.length - 1, 0));
	}


	/**
	 * 编写插值查找算法
	 * 说明：插值查找算法，也要求数组是有序的，当数据分布均匀时适合插值查找法
	 *
	 * @param arr   数组
	 * @param left  左边索引
	 * @param right 右边索引
	 * @param value 查找值
	 * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int value) {
		if (left > right || value < arr[0] || arr[arr.length - 1] < value) {
			return -1;
		}
		//求出mid
		////注意：由于除法运算会进行取整，当下表当跨度远小于数值当跨度，会报错
		int mid = (int) (left + (right - left) / ((arr[right] - arr[left]) + 0.0) * (value - arr[left]));

		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] < value) {
			return insertValueSearch(arr, left, mid - 1, value);
		} else {
			return insertValueSearch(arr, mid + 1, right, value);
		}
	}
}
