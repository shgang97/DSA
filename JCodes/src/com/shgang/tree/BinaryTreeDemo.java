package com.shgang.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {

		//创建需要的节点
		HeroNode root = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
		HeroNode node5 = new HeroNode(5, "关胜");
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);

		//创建一个二叉树
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(root);

		System.out.println("\n--------------前序遍历-------------------");
		binaryTree.preOrderErgodic();
		System.out.println("\n--------------中序遍历-------------------");
		binaryTree.infixOrderErgodic();
		System.out.println("\n--------------后序遍历-------------------");
		binaryTree.postOrderErgodic();

		System.out.println("\n--------------前序查找-------------------");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		System.out.println(resNode);
		System.out.println("\n--------------中序查找-------------------");
		resNode = binaryTree.infixOrderSearch(5);
		System.out.println(resNode);
		System.out.println("\n--------------后序查找-------------------");
		resNode = binaryTree.postOrderSearch(5);
		System.out.println(resNode);

		System.out.println("\n--------------删除5号节点-------------------");
		binaryTree.delNode(5);
		binaryTree.preOrderErgodic();
		System.out.println("\n--------------删除3号节点-------------------");
		binaryTree.delNode(3);
		binaryTree.preOrderErgodic();


	}
}


//定义BinaryTree二叉树
class BinaryTree {
	private HeroNode root;

	public BinaryTree() {
	}


	//前序遍历
	public void preOrderErgodic() {
		if (this.root != null) {
			this.root.preOrderErgodic();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	//中序遍历
	public void infixOrderErgodic() {
		if (this.root != null) {
			this.root.infixOrderErgodic();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	//后续遍历
	public void postOrderErgodic() {
		if (this.root != null) {
			this.root.postOrderErgodic();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	//前序查找
	public HeroNode preOrderSearch(int no) {
		return root == null ? null : root.preOrderSearch(no);
	}

	//中序查找
	public HeroNode infixOrderSearch(int no) {
		return root == null ? null : root.infixOrderSearch(no);
	}

	//后续查找
	public HeroNode postOrderSearch(int no) {
		return root == null ? null : root.postOrderSearch(no);
	}

	//删除节点
	public void delNode(int no) {
		if (root != null) {
			//如果只有一个root结点, 这里立即判断root是不是就是要删除结点
			if (root.getNo() == no) {
				root = null;
			} else {
				//递归删除
				root.delNode(no);
			}
		} else {
			System.out.println("孔树，不能删除～");
		}
	}
}

//创建一个HeroNode节点类
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "HeroNode{" + "no=" + no + ", name='" + name + '}';
	}

	//编写前序遍历方法
	public void preOrderErgodic() {
		System.out.println(this);
		//递归向左子树前序遍历
		if (this.left != null) {
			this.left.preOrderErgodic();
		}
		//递归向右子树前序遍历
		if (this.right != null) {
			this.right.preOrderErgodic();
		}
	}

	//编写中续遍历方法
	public void infixOrderErgodic() {
		//递归向左子树前序遍历
		if (this.left != null) {
			this.left.infixOrderErgodic();
		}
		System.out.println(this);
		//递归向右子树前序遍历
		if (this.right != null) {
			this.right.infixOrderErgodic();
		}
	}

	//编写后续遍历方法
	public void postOrderErgodic() {
		//递归向左子树前序遍历
		if (this.left != null) {
			this.left.postOrderErgodic();
		}
		//递归向右子树前序遍历
		if (this.right != null) {
			this.right.postOrderErgodic();
		}
		System.out.println(this);
	}


	/**
	 * 前序遍历查找
	 *
	 * @param no
	 * @return 如果找到就返回Node，否则返回null
	 */
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
//		return this.right == null ? this.right : this.right.preOrderSearch(no);
	}

	//中序查找
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.no == no) {
			return this;
		}
		return null;
	}

	//递归删除结点
	//1.如果删除的节点是叶子节点，则删除该节点
	//2.如果删除的节点是非叶子节点，则删除该子树
	public void delNode(int no) {
		//思路
		/*
		 * 	1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
			2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
			3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
			4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
			5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

		 */

//		if (this.left != null && this.left.no == no) {
//			this.left = null;
//			return;
//		}
//		if (this.right!=null&&this.right.no==no){
//			this.right=null;
//			return;
//		}
//		if (this.left!=null){
//			this.left.delNode(no);
//		}
//		if (this.right!=null){
//			this.right.delNode(no);
//		}
		if (this.left != null) {
			if (this.left.no == no) {
				this.left = null;
				return;
			}
			this.left.delNode(no);
		}
		if (this.right != null) {
			if (this.right.no == no) {
				this.right = null;
				return;
			}
			this.right.delNode(no);
		}
	}


}
