package com.shgang.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int[] arr = {13, 7, 8, 3, 29, 6, 1};

		Node tree = createHuffmaTree(arr);
//		tree.preOrderErgodic();
		preOrderErgodic(tree);
	}

	public static void preOrderErgodic(Node root) {
		if (root != null) {
			root.preOrderErgodic();
		} else {
			System.out.println("是空树，不能遍历～～");
		}
	}


	public static Node createHuffmaTree(int[] arr) {
		List<Node> nodes = new ArrayList<>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);

			nodes.add(parent);

		}
		return nodes.get(0);
	}
}


class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	public void preOrderErgodic() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrderErgodic();
		}
		if (this.right != null) {
			this.right.preOrderErgodic();
		}
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value + '}';
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
