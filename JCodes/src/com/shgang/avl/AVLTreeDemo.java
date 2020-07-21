package com.shgang.avl;


public class AVLTreeDemo {
	public static void main(String[] args) {
//		int[] arr = {4, 3, 6, 5, 7, 8};
//		int[] arr = {10, 12, 8, 9, 7, 6};
		int[] arr = {10, 11, 7, 6, 8, 9, 11, 12, 14, 15};
		AVLTree avlTree = new AVLTree();
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node(arr[i]));
		}
		System.out.println("*************中序遍历*****************");
		avlTree.infixOrderErgodic();
		System.out.println("*************平衡处理后*****************");
		System.out.println("树的根节点" + avlTree.getRoot());
		System.out.println("树的高度" + avlTree.getRoot().height());
		System.out.println("右子树的高度" + avlTree.getRoot().leftHeight());
		System.out.println("左子树的高度" + avlTree.getRoot().rightHeight());

		System.out.println("*************前序遍历*****************");
		avlTree.preOrderErgodic();
		System.out.println("*************后序遍历*****************");
		avlTree.postOrderErgodic();
	}
}

class AVLTree {
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

	//前序遍历
	public void preOrderErgodic() {
		if (root != null) {
			root.preOrderErgodic();
		} else {
			System.out.println("二叉排序树为空，不能遍历～～");
		}
	}

	//后续遍历
	public void postOrderErgodic() {
		if (root != null) {
			root.postOrderErgodic();
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

	//返回以该节点为根节点的树的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	//返回左子树的高度
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	//返回右子树的高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	/**
	 *
	 */
	public void leftRotate() {
		Node newNode = new Node(value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left = newNode;
	}

	public void rightRotate() {
		Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
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
		//当添加完一个节点后，如果：（右子树的高度-左子树的高度）》1，左旋转
		if (rightHeight() - leftHeight() > 1) {
			if ((right != null) && (right.leftHeight() > right.rightHeight())) {
				right.rightRotate();
			}
			leftRotate();
		}
		if (leftHeight() - rightHeight() > 1) {
			if ((left != null) && (left.rightHeight() > left.leftHeight())) {
				left.leftRotate();
			}
			rightRotate();
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

	//前序遍历
	public void preOrderErgodic() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrderErgodic();
		}
		if (this.right != null) {
			this.right.preOrderErgodic();
		}
	}

	//后续遍历
	public void postOrderErgodic() {
		if (this.left != null) {
			this.left.postOrderErgodic();
		}
		if (this.right != null) {
			this.right.postOrderErgodic();
		}
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}

