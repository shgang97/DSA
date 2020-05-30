package com.shgang.test;

import com.shgang.sort.Bubble;

import java.util.Arrays;

public class BubbleTest {
	public static void main(String[] args) {
		Integer[] arr={4,5,8,3,0,3};
		Bubble.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
