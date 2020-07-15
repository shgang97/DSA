package com.shgang.search;

import java.util.Arrays;

public class FibonacciSearch {
	public static void main(String[] args) {
		int[] arr = {1, 8, 10, 89, 1000, 1234};
		System.out.println("index=" + fibSearch(arr, 89));// 0
	}

	/**
	 * @param arr
	 * @param value
	 * @return 返回对应的下标，如果没有找到返回-1
	 */
	public static int fibSearch(int[] arr, int value) {
		int k = 0;
		int lo = 0;
		int hi = arr.length - 1;
		int mid;
		int[] f;
		if (hi < 7) {
			f = fib(7);
		} else {
			f = fib(hi);
		}
		while (f[k++] - 1 < hi) ;
		int[] temp = Arrays.copyOf(arr, f[k] - 1);
		for (int i = hi + 1; i < temp.length; i++) {
			temp[i] = arr[hi];
		}
		while (lo <= hi) {
			mid = lo + f[k - 1] - 1;
			if (value < temp[mid]) {
				hi = mid - 1;
				k--;
			} else if (temp[mid] < value) {
				lo = mid + 1;
				k -= 2;
			} else {
				return mid < hi ? mid : hi;
			}
		}
		return -1;
	}

	public static int[] fib(int maxSize) {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
}
