package com.shgang.sort;

public class SortTest {
	public static void main(String[] args) {
		int[] arr = genRandomNum(80000, 800000);
		long start = System.currentTimeMillis();

		//冒泡排序
		//优化：冒泡排序花费时间：19598毫秒
		//未优化：冒泡排序花费时间：18781毫秒
//		System.out.println("---------------冒泡排序----------------");
//		BubbleSort.bubbleSort(arr);
//		System.out.println("冒泡排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

		//选择排序
		//选择排序花费时间：6131毫秒
//		System.out.println("---------------选择排序----------------");
//		SelectionSort.selectionSort(arr);
//		System.out.println("选择排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

//		//插入排序
//		//插入排序花费时间：6933毫秒
//		//插入排序花费时间：5288毫秒
//		//插入排序花费时间：1065毫秒
//		System.out.println("---------------插入排序----------------");
//		InsertionSort.insertionSort(arr);
//		System.out.println("插入排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

//		希尔排序
//		希尔排序花费时间：30毫秒
//		System.out.println("---------------希尔排序----------------");
//		ShellSort.shellSort(arr);
//		System.out.println("希尔排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

		//快速排序
		//快速排序花费时间：41毫秒
//		System.out.println("---------------快速排序----------------");
//		QuickSort.quickSort(arr, 0, arr.length - 1);
//		System.out.println("快速排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

		//归并排序
		//归并排序花费时间：58毫秒
//		System.out.println("---------------归并排序----------------");
//		int[] temp = new int[arr.length];
//		MergeSort.mergeSort(arr, 0, arr.length - 1, temp);
//		System.out.println("归并排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");

		//基数排序
		//基数排序花费时间：30毫秒
		System.out.println("---------------基数排序----------------");
		RadixSort.radixSort(arr);
		System.out.println("基数排序花费时间：" + (System.currentTimeMillis() - start) + "毫秒");
//		System.out.println(Arrays.toString(arr));

	}

	//方法：生成随机数
	public static int[] genRandomNum(int num, int max) {
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max);
		}
		return arr;
	}
}
