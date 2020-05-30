package com.shgang.test;

import com.shgang.sort.Shell;

import java.util.Arrays;

public class ShellTest {
	public static void main(String[] args) {
		Integer[] arr={4,3,5,8,0,6,7,9,9,0,2,4,5};
		long start = System.currentTimeMillis();
		Shell.sort(arr);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(Arrays.toString(arr));
	}
}
