package com.shgang.test;

import com.shgang.tree.BinaryTree;
import com.shgang.tree.Queue;

public class BinaryTreeErgodicTest {
	public static void main(String[] args) {
		BinaryTree<String, String> bt = new BinaryTree<>();
		bt.put("E","5");
		bt.put("B","2");
		bt.put("G","7");
		bt.put("A","1");
		bt.put("D","4");
		bt.put("F","6");
		bt.put("H","8");
		bt.put("C","3");

//		Queue<String> keys = bt.preErgodic();
//		for (String key : keys) {
//			String value = bt.get(key);
//			System.out.println(key+"------"+value);
//		}

//		Queue<String> keys2 = bt.midErgodic();
//		for (String key : keys2) {
//			String value = bt.get(key);
//			System.out.println(key+"------"+value);
//		}

//		Queue<String> keys = bt.layerErgodic();
//		for (String key : keys) {
//			String value = bt.get(key);
//			System.out.println(key+"------------"+value);
//		}

		Queue<String> keys = bt.afterErgodic();
		for (String key : keys) {
			String value = bt.get(key);
			System.out.println(key+"------------"+value);
		}


	}
}
