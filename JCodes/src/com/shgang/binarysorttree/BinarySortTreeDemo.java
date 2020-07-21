package com.shgang.binarysorttree;


public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		//创建一个二叉排序树并循环添加节点到二叉排序树中
		BinarySortTree bsTree = new BinarySortTree();
		for (int i = 0; i < arr.length; i++) {
			bsTree.add(new Node(arr[i]));
		}
		//中序遍历二叉排序树
		System.out.println("-------------中序遍历二叉排序树-----------------");
		bsTree.infixOrderErgodic();

		//测试删除叶子节点
//		System.out.println("\n-------------删除叶子节点后-----------------");
//		bsTree.delNode(2);
//		bsTree.delNode(5);
//		bsTree.delNode(9);
//		bsTree.delNode(12);

//		//删除只有一个子树的节点
//		System.out.println("\n-------------删除有一个子树的节点后-----------------");
//		bsTree.delNode(1);

		//删除有2个子树的节点
//		System.out.println("\n-------------删除有2个子树的节点后-----------------");
//		bsTree.delNode(7);
//		bsTree.infixOrderErgodic();

		System.out.println("\n-------------删除所有节点-----------------");
		for (int i = 0; i < arr.length - 1; i++) {
			bsTree.delNode(arr[i]);
		}
		bsTree.infixOrderErgodic();


	}
}

class BinarySortTree {
	private Node root;

	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	//中序遍历
	public void infixOrderErgodic() {
		if (root != null) {
			root.infixOrderErgodic();
		} else {
			System.out.println("二叉排序树为空，不能遍历～～");
		}
	}

	//查找要删除的节点
	public Node search(int value) {
		if (root == null) {
			return null;
		}
		return root.search(value);
	}

	//查找要删除的父节点
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		}
		return root.searchParent(value);
	}


	/**
	 * 删除节点
	 * 第一种情况:
	 * 删除叶子节点 (比如：2, 5, 9, 12)
	 * 思路
	 * (1) 需求先去找到要删除的结点  targetNode
	 * (2)  找到targetNode 的 父结点 parent
	 * (3)  确定 targetNode 是 parent的左子结点 还是右子结点
	 * (4)  根据前面的情况来对应删除
	 * 左子结点 parent.left = null
	 * 右子结点 parent.right = null;
	 * 第二种情况: 删除只有一颗子树的节点 比如 1
	 * 思路
	 * (1) 需求先去找到要删除的结点  targetNode
	 * (2)  找到targetNode 的 父结点 parent
	 * (3) 确定targetNode 的子结点是左子结点还是右子结点
	 * (4) targetNode 是 parent 的左子结点还是右子结点
	 * (5) 如果targetNode 有左子结点
	 * 5. 1 如果 targetNode 是 parent 的左子结点
	 * parent.left = targetNode.left;
	 * 5.2  如果 targetNode 是 parent 的右子结点
	 * parent.right = targetNode.left;
	 * (6) 如果targetNode 有右子结点
	 * 6.1 如果 targetNode 是 parent 的左子结点
	 * parent.left = targetNode.right;
	 * 6.2 如果 targetNode 是 parent 的右子结点
	 * parent.right = targetNode.right
	 * <p>
	 * <p>
	 * 情况三 ： 删除有两颗子树的节点. (比如：7, 3，10 )
	 * 思路
	 * (1) 需求先去找到要删除的结点  targetNode
	 * (2)  找到targetNode 的 父结点 parent
	 * (3)  从targetNode 的右子树找到最小的结点
	 * (4) 用一个临时变量，将 最小结点的值保存 temp = 11
	 * (5)  删除该最小结点
	 * (6)  targetNode.value = temp
	 *
	 * @param value
	 */
	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);
			//如果要删除的节点是叶子节点
			if (targetNode.left == null && targetNode.right == null) {
				//判断targetNode是父父节点的左子节点还是右子节点
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) {//删除有2个子树的节点
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
			} else {//删除只有一个子树的节点
				if (targetNode.left != null) {
					if (parent != null) {
						if (parent.left.value == value) {
							parent.left = targetNode.left;
						} else {
							parent.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else {
					if (parent != null) {
						if (parent.left.value == value) {
							parent.left = targetNode.right;
						} else {
							parent.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}


	}

	/**
	 * @param node 传入的节点（当前二叉排序树的根节点）
	 * @return 返回的以node为根节点的二叉排序树的最小节点的值
	 */
	public int delRightTreeMin(Node node) {
		Node temp = node;
		//循环的查找左节点，就会找到最小值
		while (temp.left != null) {
			temp = temp.left;
		}
		delNode(temp.value);
		return temp.value;
	}

	public Node getRoot() {
		return root;
	}
}

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}

	//查找要删除的节点
	public Node search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	//查找要删除节点的父节点
	public Node searchParent(int value) {
		if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (this.value < value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}

	//添加节点的方法
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}


	//中序遍历二叉排序树
	public void infixOrderErgodic() {
		if (this.left != null) {
			this.left.infixOrderErgodic();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrderErgodic();
		}
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}
