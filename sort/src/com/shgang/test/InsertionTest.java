package com.shgang.test;

import com.shgang.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {
	public static void main(String[] args) {
		int[] arr={4,3,5,8,0,6,7,9,9,0,2,4,5};
		Insertion.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
