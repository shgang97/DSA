package com.shgang.test;

import com.shgang.tree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<Integer,String> tree = new BinaryTree<>();
		tree.put(1,"张三");
		tree.put(2,"李四");
		tree.put(3,"王五");
		System.out.println("插入完毕后元素的个数："+tree.size());

		System.out.println("键2对应的元素是："+tree.get(2));

		tree.delete(3);
		System.out.println("键2对应的元素是："+tree.get(3));
		System.out.println("删除后元素的个数是："+tree.size());
	}
}
