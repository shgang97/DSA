package com.shgang.algorithm.dynamicprogram;

public class KnapsackProgram {
	public static void main(String[] args) {
		int[] weight = {1, 4, 3};//物品的重量
		int[] value = {1500, 3000, 2000};//物品的价值
		int capacity = 4;//背包的容量
		int num = value.length;//物品的个数
		//创建二维数组
		//sumValue[i][j]表示前i个物品中，能够装入容量为j的背包最大价值
		int[][] sumValue = new int[num + 1][capacity + 1];
		int[][] path = new int[num + 1][capacity + 1];

		for (int i = 0; i < sumValue.length; i++) {
			sumValue[i][0] = 0;
		}
		for (int i = 0; i < sumValue[0].length; i++) {
			sumValue[0][i] = 0;
		}
		for (int i = 1; i < sumValue.length; i++) {
			for (int j = 1; j < sumValue[i].length; j++) {
				if (j < weight[i - 1]) {
					sumValue[i][j] = sumValue[i - 1][j];
				} else {
					if (sumValue[i - 1][j] < (value[i - 1] + sumValue[i - 1][j - weight[i - 1]])) {
						sumValue[i][j] = value[i - 1] + sumValue[i - 1][j - weight[i - 1]];
						path[i][j] = 1;
					} else {
						sumValue[i][j] = sumValue[i - 1][j];
						path[i][j] = 0;
					}
//					sumValue[i][j] = sumValue[i - 1][j] < (value[i - 1] + sumValue[i - 1][j - weight[i - 1]]) ? (value[i - 1] + sumValue[i - 1][j - weight[i - 1]]) : sumValue[i - 1][j];
//					path[i][j] = sumValue[i - 1][j] < (value[i - 1] + sumValue[i - 1][j - weight[i - 1]]) ? 1 : 0;
				}
			}
		}
		for (int i = 0; i < sumValue.length; i++) {
			for (int j = 0; j < sumValue[i].length; j++) {
//				System.out.print(sumValue[i][j] + "\t");
				System.out.print(path[i][j] + "\t");

			}
			System.out.println();
		}
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("第%d个物品放入背包\n", i);
				j -= weight[i - 1];
			}
			i--;
		}
	}
}
