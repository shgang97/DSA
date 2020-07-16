package com.shgang.tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
//		int[] arr = {};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		System.out.println("---------------前序遍历--------------------");
		arrBinaryTree.preOrderErgodic();
		System.out.println("\n---------------中序遍历--------------------");
		arrBinaryTree.infixOrderErgodic();
		System.out.println("\n---------------后序遍历--------------------");
		arrBinaryTree.postOrderErgodic();
	}


}

/*
顺序存储二叉树的特点:

1）顺序二叉树通常只考虑完全二叉树
2）第n个元素的左子节点为  2 * n + 1
3）第n个元素的右子节点为  2 * n + 2
4）第n个元素的父节点为  (n-1) / 2
5）n : 表示二叉树中的第几个元素(按0开始编号 如图所示)

 */
//编写一个ArrBinaryTree
class ArrBinaryTree {
	private int[] arr;


	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}

	/**
	 * 重载preOrderErgodic方法
	 */
	public void preOrderErgodic() {
		this.preOrderErgodic(0);
	}

	/**
	 * 顺序存储二叉树的前序遍历
	 *
	 * @param index 数组的下标
	 */
	public void preOrderErgodic(int index) {
		//如果数组为空，或者arr.length=0
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
			return;
		}
		//输出当前这个元素
		System.out.println(arr[index]);
		//向左递归遍历
		if (index * 2 + 1 < arr.length) {
			preOrderErgodic(2 * index + 1);
		}
		//向右递归遍历
		if (index * 2 + 2 < arr.length) {
			preOrderErgodic(2 * index + 2);
		}
	}

	public void infixOrderErgodic() {
		this.infixOrderErgodic(0);
	}

	//顺序存储二叉树的中序遍历
	public void infixOrderErgodic(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能遍历");
			return;
		}
		if (2 * index + 1 < arr.length) {
			infixOrderErgodic(2 * index + 1);
		}
		System.out.println(arr[index]);
		if (2 * index + 2 < arr.length) {
			infixOrderErgodic(2 * index + 2);
		}
	}

	public void postOrderErgodic() {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能遍历");
			return;
		}
		this.postOrderErgodic(0);
	}

	private void postOrderErgodic(int index) {
		if (2 * index + 1 < arr.length) {
			postOrderErgodic(2 * index + 1);
		}
		if (2 * index + 2 < arr.length) {
			postOrderErgodic(2 * index + 2);
		}
		System.out.println(arr[index]);
	}

}