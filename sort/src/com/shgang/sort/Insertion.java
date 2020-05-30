package com.shgang.sort;

public class Insertion {
	public static void sort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j=i;j>0;j--){
				if (arr[j]>=arr[j-1]){
					break;
				}else {
					arr[j]=arr[j]+arr[j-1];
					arr[j-1]=arr[j]-arr[j-1];
					arr[j]=arr[j]-arr[j-1];
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
	}
}
