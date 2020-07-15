package com.shgang.search;

import com.shgang.sort.ShellSort;
import com.shgang.sort.SortTest;

public class SearchTest {
	public static void main(String[] args) {
		int[] arr = SortTest.genRandomNum(80000000, 80000);
		ShellSort.shellSort(arr);
		int value = arr[9999999];
		System.out.println("需要查找的元素值为：" + value);

		System.out.println("-------------二分查找---------------");
		long start1 = System.currentTimeMillis();
		int index1 = BinarySearch.binarySearch(arr, 0, arr.length - 1, value);
		System.out.println("查找结果为：" + index1 + ",所用时间为" + (System.currentTimeMillis() - start1) + "毫秒\n");

		System.out.println("-------------斐波那契查找---------------");
		long start2 = System.currentTimeMillis();
		int index2 = FibonacciSearch.fibSearch(arr, value);
		System.out.println("查找结果为：" + index2 + ",所用时间为" + (System.currentTimeMillis() - start2) + "毫秒\n");

		System.out.println("-------------线性查找---------------");
		long start3 = System.currentTimeMillis();
		int index3 = SeqSearch.seqSearch(arr, value);
		System.out.println("查找结果为：" + index3 + ",所用时间为" + (System.currentTimeMillis() - start3) + "毫秒\n");

		System.out.println("-------------插值查找---------------");
		long start4 = System.currentTimeMillis();
		int index4 = InsertValueSearch.insertValueSearch(arr, 0, arr.length - 1, value);
		System.out.println("查找结果为：" + index4 + ",所用时间为" + (System.currentTimeMillis() - start4) + "毫秒\n");

		System.out.println(arr[index1]);
		System.out.println(arr[index2]);
		System.out.println(arr[index3]);
		System.out.println(arr[index4]);
	}
}

/*
 * 需要查找的元素值为：0
 * -------------二分查找---------------
 * 查找结果为：609,所用时间为3毫秒
 * <p>
 * -------------斐波那契查找---------------
 * 查找结果为：986,所用时间为1827毫秒
 * <p>
 * -------------线性查找---------------
 * 查找结果为：0,所用时间为4毫秒
 * <p>
 * -------------插值查找---------------
 * 查找结果为：0,所用时间为1毫秒
 */

/*
需要查找的元素值为：9994
-------------二分查找---------------
查找结果为：9999999,所用时间为0毫秒

-------------斐波那契查找---------------
查找结果为：10000593,所用时间为1474毫秒

-------------线性查找---------------
查找结果为：9999808,所用时间为11毫秒

-------------插值查找---------------
查找结果为：10000126,所用时间为4毫秒
 */
