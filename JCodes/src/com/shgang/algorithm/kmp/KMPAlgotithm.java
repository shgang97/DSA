package com.shgang.algorithm.kmp;

import java.util.Arrays;

public class KMPAlgotithm {
	public static void main(String[] args) {
//		String str1 = "BBC ABCDAB ABCDABCDABDE";
//		String str2 = "ABCDABD";
		String str1="寻寻觅觅，冷冷清清，凄凄惨惨戚戚";
		String str2="冷冷清清";
		int[] next = kmpNext(str2);
		System.out.println(Arrays.toString(next));
		int index = kmpMatch(str1, str2);
		System.out.println(index);

	}

	public static int kmpMatch(String str1, String str2) {
		String dest = str1.length() < str2.length() ? str1 : str2;
		String src = str1.length() < str2.length() ? str2 : str1;
		int[] next = kmpNext(dest);
		for (int i = 0, j = 0; i < src.length(); i++) {
			while (j > 0 && src.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
				//下述移动方法本质结果同上，但是下述方法重复比较了，浪费了时间
//				i-=next[j-1];
//				j=0;
			}
			if (src.charAt(i) == dest.charAt(j)) {
				j++;
			}
			if (j == dest.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

	//获取到一个字符串（子串）到部分匹配值表
	public static int[] kmpNext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < dest.length(); i++) {
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
