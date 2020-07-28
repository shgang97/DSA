package com.shgang.algorithm.kruskal;

import java.util.Arrays;

public class KruskaCase {
	public static void main(String[] args) {
		char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int matrix[][] = {
				{0, 12, INF, INF, INF, 16, 14},
				{12, 0, 10, INF, INF, 7, INF},
				{INF, 10, 0, 3, 5, 6, INF},
				{INF, 10, 3, 0, 4, INF, INF},
				{INF, INF, 5, 4, 0, 2, 8},
				{16, 7, 6, INF, 2, 0, 9},
				{14, INF, INF, INF, 8, 9, 0}
		};
		//创建一个KruskaCase
		KruskaCase kruskaCase = new KruskaCase(vertexs, matrix);
		kruskaCase.print();
		kruskaCase.kruskal();
	}

	private int edgeNum;
	private char[] vertexs;
	private int[][] matrix;

	private static final int INF = Integer.MAX_VALUE;


	public KruskaCase(char[] vertexs, int[][] matrix) {
		//初始化顶点和边的个数
		int vlen = vertexs.length;

		//初始化顶点
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}

		//初始化边
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++) {
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		//统计边
		for (int i = 0; i < vlen; i++) {
			for (int j = i + 1; j < vlen; j++) {
				edgeNum++;
			}
		}
	}

	private void kruskal() {
		int index = 0;
		int[] ends = new int[edgeNum];
		EData[] rets = new EData[edgeNum];
		EData[] edges = getEdges();
		System.out.println("图的边的集合 = " + Arrays.toString(edges));
		sortEdges(edges);
		//遍历edges数组
		for (int i = 0; i < edgeNum; i++) {
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			if (m != n) {
				ends[m] = n;
				rets[index++] = edges[i];
			}
		}
		System.out.println("最小生成树为：" + Arrays.toString(rets));
	}

	/**
	 * 功能：对边进行排序处理, 冒泡排序
	 *
	 * @param edges 边的集合
	 */
	private void sortEdges(EData[] edges) {
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = 0; j < edges.length - 1 - i; j++) {
				if (edges[j].weight > edges[j + 1].weight) {//交换
					EData tmp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = tmp;
				}
			}
		}
	}

	public void print() {
		System.out.println("临街矩阵为：\n");
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.printf("%12d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

	private int getPosition(char ch) {
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	private EData[] getEdges() {
		int index = 0;
		EData[] edges = new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = i + 1; j < vertexs.length; j++) {
				if (matrix[i][j] != INF) {
					edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
				}
			}
		}
		return edges;
	}

	private int getEnd(int[] ends, int i) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		return i;
	}
}

//创建一个EData，他的对象实例表示一条边
class EData {
	char start;
	char end;
	int weight;

	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	//重写toString方法

	@Override
	public String toString() {
		return "EData{" +
				"start=" + start +
				", end=" + end +
				", weight=" + weight +
				'}';
	}
}