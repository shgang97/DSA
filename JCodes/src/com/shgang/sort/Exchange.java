package com.shgang.sort;

import java.util.Arrays;

public class Exchange {
	public static void main(String[] args) {
		int tmp = 0;
		int num1 = 10;
		int num2 = 20;
		tmpExchange(tmp, num1, num2);
		xorExchange(num1, num2);
		addExchange(num1, num2);
		mulExchange(num1, num2);
		int[] arr = {0, 1};
		xorExchange(arr, 1, 1);
		System.out.println(Arrays.toString(arr));

	}

	public static void tmpExchange(int tmp, int num1, int num2) {
		tmp = num1;
		num1 = num2;
		num2 = tmp;
//		System.out.println("临时变量法：" + "num1 = " + num1 + "\t" + "num2 = " + num2);
	}

	public static void xorExchange(int num1, int num2) {
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;
//		System.out.println("异或法：" + "num1 = " + num1 + "\t" + "num2 = " + num2);
	}

	public static void xorExchange(int[] arr, int i, int j) {
		if (i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}

	public static void addExchange(int num1, int num2) {
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
//		System.out.println("相加法：" + "num1 = " + num1 + "\t" + "num2 = " + num2);
	}

	public static void mulExchange(int num1, int num2) {
		num1 = num1 * num2;
		num2 = num1 / num2;
		num1 = num1 / num2;
//		System.out.println("相乘法：" + "num1 = " + num1 + "\t" + "num2 = " + num2);
	}
}
