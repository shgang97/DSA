package com.shgang.tree;

public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {
		Node root = new Node(1, "tom");
		Node node2 = new Node(3, "jack");
		Node node3 = new Node(6, "smith");
		Node node4 = new Node(8, "marry");
		Node node5 = new Node(10, "king");
		Node node6 = new Node(14, "dim");

		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);

		//创建一个线索化二叉树
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		tree.setRoot(root);
		tree.infixThreadNode();

		Node leftNode = node5.getLeft();
		System.out.println(leftNode);
		Node rightNode = node5.getRight();
		System.out.println(rightNode);
		tree.infixOrderErgodic();

	}


}


//递归ThreadedBinaryTree实现了线索话功能的二叉树
class ThreadedBinaryTree extends BinaryTree {
	private Node root;
	//为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
	//在递归进行线索化时，pre 总是保留前一个结点
	private Node pre = null;

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * 编写对二叉树进行中序线索化的方法
	 *
	 * @param node 当前需要线索化的节点
	 */
	public void infixThreadNode(Node node) {
		if (node == null) {
			return;
		}
		//（一）先线索化左子树
		infixThreadNode(node.getLeft());
		//（二）线索化当前节点
		//1、处理当前节点的前驱节点
		if (node.getLeft() == null) {
			//让当前节点的左指针指向前驱节点
			node.setLeft(pre);
			//修改当前节点的左指针的类型，指向前驱节点
			node.setLeftType(1);
		}
		//2、处理后继节点
		if (pre != null && pre.getRight() == null) {
			//让前驱节点的右指针指向当前节点
			pre.setRight(node);
			//修改当前节点的右指针类型
			pre.setRightType(1);
		}
		pre = node;
		//（三）再线索话右子树
		infixThreadNode(node.getRight());
	}

	//重载中序线索化二叉树方法
	public void infixThreadNode() {
		this.infixThreadNode(root);
	}


	//重写中序遍历线索化二叉树
	@Override
	public void infixOrderErgodic() {
		//定义一个变量，存储当前遍历的节点
		Node node = root;
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
}

class Node extends HeroNode {
	private Node left;
	private Node right;
	//说明：
	//1.如果leftType==0表示指向的是左子树，如果==1则表示指向前驱节点
	//1.如果rightType==0表示指向的是右子树，如果==1则表示指向后继节点
	private int leftType;
	private int rightType;

	public Node(int no, String name) {
		super(no, name);
	}

	@Override
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	@Override
	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}


	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
}
