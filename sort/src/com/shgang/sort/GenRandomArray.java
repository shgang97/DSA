package com.shgang.sort;

public class GenRandomArray {
	public static int[] genRandomArray(int len,int max){
		int[] arr=new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*max);
		}
		return arr;
	}

	public static Integer[] genRandomArrays(int len,int max){
		Integer[] arr=new Integer[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*max);
		}
		return arr;
	}


}
