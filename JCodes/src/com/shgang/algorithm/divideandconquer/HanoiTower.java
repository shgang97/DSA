package com.shgang.algorithm.divideandconquer;

public class HanoiTower {
	public static void main(String[] args) {
		hanoiTower(5, "A", "B", "C");

	}

	public static void hanoiTower(int num, String from, String mid, String to) {
		if (num == 1) {
			System.out.println("第1个盘从" + from + "->" + to);
		} else {
			hanoiTower(num - 1, from, to, mid);
			System.out.println("第" + num + "个盘从" + from + "->" + to);
			hanoiTower(num - 1, mid, from, to);
		}
	}
}
