package com.shgang.sort;

public class Shell2 {
	public static void sort(int[] arr) {
		int h = 1;
		while (h >= arr.length / 2) {
			h = h * 2 + 1;
		}

		while (h >= 1) {

			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
					arr[j] = arr[j] + arr[j - h];
					arr[j - h] = arr[j] - arr[j - h];
					arr[j] = arr[j] - arr[j - h];

				}
			}
			h = h / 2;
		}
	}
}

