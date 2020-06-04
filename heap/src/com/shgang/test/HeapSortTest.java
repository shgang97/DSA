package com.shgang.test;

import com.shgang.heap.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
	public static void main(String[] args) {
//		待排序数组
		String[] arr={"S","O","R","T","E","X","A","M","P","L","W"};
//		通过heapSort对数组中的元素进行排序
		HeapSort.sort(arr);
//		打印排序后数组中的元素
		System.out.println(Arrays.toString(arr));



	}
}
