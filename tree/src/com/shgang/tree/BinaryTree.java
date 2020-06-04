package com.shgang.tree;


public class BinaryTree<Key extends Comparable<Key>,Value> {
	private Node root;
	private int N;

	private class Node {
		public Key key;
		private Value value;
		public Node left;
		public Node right;

		public Node(Key key, Value value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public int size(){
		return N;
	}

	public void put(Key key, Value value){
		root=put(root,key,value);

	}

	public Node put(Node x,Key key,Value value){
		if (x==null){
			N++;
			return new Node(key,value,null,null);
		}
		int cmp=key.compareTo(x.key);
		if (cmp>0){
			x.right=put(x.right,key,value);
		}else if (cmp<0){
			x.left=put(x.left,key,value);
		}else {
			x.value=value;
		}
		return x;
	}

	public Value get(Key key){
		return get(root,key);
	}

	public Value get(Node x,Key key){
		if (x==null){
			return null;
		}
		int cmp=key.compareTo(x.key);
		if (cmp>0){
			return get(x.right,key);
		}else if (cmp<0){
			return get(x.left,key);
		}else {
			return x.value;
		}
	}

	public void delete(Key key){
		delete(root,key);
	}

	public Node delete(Node x,Key key){
		if (x==null){
			return null;
		}

		int cmp=key.compareTo(x.key);
		if (cmp>0){
			x.right= delete(x.right,key);
		}else if (cmp<0){
			x.left= delete(x.left,key);
		}else {
			N--;
			if (x.right==null){
				return x.left;
			}
			if (x.left==null){
				return x.right;
			}
			Node minNode = x.right;
			while (minNode.left!=null){
				minNode=minNode.left;
			}

			Node n=x.right;
			while (n.left!=null){
				if  (n.left.left==null){
					n.left=null;
				}else {
					n=n.left;
				}
			}
			minNode.left=x.left;
			minNode.right=x.right;
			x=minNode;
		}
		return x;
	}

	public Key min(){
		return min(root).key;
	}

	public Node min(Node x){
		if (x.left!=null){
			return min(x.left);
		}else {
			return x;
		}
	}

	public Key mmax(){
		return max(root).key;
	}

	public Node max(Node x){
		if (x.right!=null){
			return max(x.right );
		}else {
			return x;
		}
	}

	public Queue<Key> preErgodic(){
		Queue<Key> keys = new Queue<>();
		preErgodic(root,keys);
		return keys;
	}

	public void preErgodic(Node x,Queue<Key>keys){
		if (x==null){
			return;
		}
		keys.enqueue(x.key);
		if (x.left!=null){
			preErgodic(x.left,keys);
		}
		if (x.right!=null){
			preErgodic(x.right,keys);
		}
	}

	public Queue<Key> midErgodic(){
		Queue<Key> keys = new Queue<>();
		midErgodic(root,keys);
		return keys;
	}

	public void midErgodic(Node x,Queue<Key> keys){
		if (x==null){
			return;
		}
		if (x.left!=null){
			midErgodic(x.left,keys);
		}
		if (x.right!=null){
			midErgodic(x.right,keys);
		}
	}

	public Queue<Key> afterErgodic(){
		Queue<Key> keys = new Queue<>();
		afterErgodic(root,keys);
		return keys;
	}

	private void afterErgodic(Node x,Queue<Key> keys){
		if (x==null){
			return;
		}
		if (x.left!=null){
			afterErgodic(x.right,keys);
		}
		if (x.right!=null){
			afterErgodic(x.right,keys);
		}
		keys.enqueue(x.key);
	}

	public Queue<Key> layerErgodic(){
		Queue<Key> keys = new Queue<>();
		Queue<Node> nodes = new Queue<Node>();
		nodes.enqueue(root);
		while (!nodes.isEmpty()){
			Node n = nodes.dequeue();
			keys.enqueue(n.key);
			if (n.left!=null){
				nodes.enqueue(n.left);
			}
			if (n.right!=null){
				nodes.enqueue(n.right);
			}
		}
		return keys;
	}

	public int maxDepth(){
		return maxDepth(root);
	}

	private int maxDepth(Node x){
		if (x==null){
			return 0;
		}
		int max=0;
		int maxL=0;
		int maxR=0;

		if (x.left!=null){
			maxL=maxDepth(x.left);
		}

		if (x.right!=null){
			maxR=maxDepth(x.right);
		}
		max = maxL > maxR ? maxL + 1 : maxR + 1;
		return max;
	}
}
