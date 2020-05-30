package com.shgang.sort;

public class Shell3 {
	public static void sort(int[] arr) {
//		int j;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i; j >= gap && arr[j] < arr[j - gap]; j-=gap) {
					arr[j] = arr[j] + arr[j - gap];
					arr[j - gap] = arr[j] - arr[j - gap];
					arr[j] = arr[j] - arr[j - gap];

				}
			}
		}
	}
}
