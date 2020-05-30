package com.shgang.sort;

public class Selection {
	public static void sort(int[] arr){

		for (int i = 0; i < arr.length-1; i++) {
			int index=i;
			int temp=arr[index];
			for (int j = i+1; j < arr.length; j++) {
				if (arr[index]>arr[j]){
					index=j;
				}
			}
			arr[i]=arr[index];
			arr[index]=temp;
		}
	}
}
