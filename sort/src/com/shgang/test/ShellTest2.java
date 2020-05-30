package com.shgang.test;

import com.shgang.sort.GenRandomArray;
import com.shgang.sort.Merge;

public class ShellTest2 {
	public static void main(String[] args) {
		int[] arr= GenRandomArray.genRandomArray(100000,100000);
		Integer[] integers = GenRandomArray.genRandomArrays(100000, 100000);
		long start = System.currentTimeMillis();

		Merge.sort(integers);

//		Shell3.sort(arr);
//		System.out.println("希尔排序的时间"+(System.currentTimeMillis()-start)+"毫秒");
//		System.out.println(Arrays.toString(arr));

//		Insertion.sort(arr);
//		System.out.println("插入排序的时间"+(System.currentTimeMillis()-start)+"毫秒");
//
//		Selection.sort(arr);
//		System.out.println("选择排序的时间"+(System.currentTimeMillis()-start)+"毫秒");

//		Shell.sort(integers);
		System.out.println("希尔排序的时间"+(System.currentTimeMillis()-start)+"毫秒");

		for (int i = 0; i < arr.length; i+=1000) {
			System.out.println(arr[i]);
		}
	}
}
