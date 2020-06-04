package com.shgang.test;

import com.shgang.tree.Queue;

public class PageFoldingTest {
	public static void main(String[] args) {
		Node<String> tree = creatTree(2);
		printTree(tree);
	}

	public static Node<String> creatTree(int N){
		Node<String> root=null;
		for (int i=0;i<N;i++){
			if (i==0){
				root=new Node<>("down",null,null);
				continue;
			}
			Queue<Node> queue = new Queue<>();
			queue.enqueue(root);
			while (!queue.isEmpty()){
				Node<String> tmp = queue.dequeue();
				if (tmp.left!=null){
					queue.enqueue(tmp.left);
				}
				if (tmp.right!=null){
					queue.enqueue(tmp.right);
				}
				if (tmp.left==null && tmp.right==null){
					tmp.left=new Node("dowm",null,null);
					tmp.right=new Node("up",null,null);
				}
			}
		}
		return root;
	}


	public static void printTree(Node<String> root){
		if (root==null){
			return;
		}
		if (root.left!=null){
			printTree(root.left);
		}
		System.out.print(root.item+" ");

		if (root.right!=null){
			printTree(root.right);
		}
		System.out.print(root.item+" ");
	}

	private static class Node<T> {
		public T item;
		public Node left;
		public Node right;


		private Node(T item, Node left, Node right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
}
