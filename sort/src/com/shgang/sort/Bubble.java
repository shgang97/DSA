package com.shgang.sort;

public class Bubble {
	public static void sort(Integer[] arr){
		for (int i=arr.length-1;i>0;i--){
			for (int j=0;j<i;j++){
				if (arr[j]>arr[j+1]){
					arr[j+1]=arr[j]+arr[j+1];
					arr[j]=arr[j+1]-arr[j];
					arr[j+1]=arr[j+1]-arr[j];
				}
			}
		}
	}
}
