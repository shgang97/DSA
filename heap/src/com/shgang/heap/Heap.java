package com.shgang.heap;

public class Heap<T extends Comparable<T>> {
	private T[] items;
	private int N;

	public Heap(int capacity) {
		this.items = (T[]) new Comparable[capacity+1];
	}

	//	判读堆中索引i处堆元素是否小于索引j处的元素
	private boolean less(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}


	//	交换堆中i索引和j索引处堆值
	private void exch(int i, int j) {
		T temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	//	在堆中插入一个元素
	public void insert(T t) {
		items[++N] = t;
		swim(N);
	}

	//	使用上浮算法，使索引k处的元素能在堆中处于一个正确堆位置
	private void swim(int k) {
		//  通过循环不断比较当前节点的值和其父节点的值，如果发现父节点的值比当前节点的值小，则交换位置
		while (k > 1) {
			if (less(k / 2, k)) {
				exch(k / 2, k);
			}
			k /= 2;
		}
	}

	//	删除堆中最大的元素，并返回这个最大元素
	public T delMax() {
		T max = items[1];
		//  交换索引1处的元素和最大索引处的元素，让完全二叉树中最右侧的元素变为临时节点
		exch(1, N);
		//  最大索引处的元素删掉
		items[N] = null;
		//元素个数-1
		N--;
		//  通过下沉调整堆，让堆重新有序
		sink(1);
		return max;
	}

	//  使用下沉算法
	private void sink(int k) {
		//  通过循环不断的对比当前k节点和其左子节点2k+1处中的较大值的元素大小，如果当前的节点小，则需要交换位置
		while (2 * k <= N) {
			//  获取当前节点的子节点中的较大节点
			int max;//  记录较大节点所在的索引
			if (2 * k + 1 <= N) {

				max = less(2 * k, 2 * k + 1) ? 2 * k + 1 : 2 * k;
//				if (less(2*k,2*k+1)){
//					max=2*k+1;
//				}else {
//					max=2*k;
			} else {
				max = 2 * k;
			}

			//  比较当前节点和较大节点的值
			if (!less(k, max)) {
				break;
			}

			//  交换k索引处的值和max索引处的值
			k = max;
		}
	}

}

