package com.shgang.test;

import com.shgang.sort.Selection;

import java.util.Arrays;

public class SelectionTest {
	public static void main(String[] args) {
		int[] arr={4,5,8,3,0,3};
		Selection.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
