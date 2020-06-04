package com.shgang.tree;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
	private Node head;
	private Node last;
	private int N;

	public Queue() {
		this.head = new Node(null,null);
		this.last = null;
		N = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new QIterator();
	}

	private class QIterator implements Iterator{
		private Node n;
		public QIterator(){
			this.n=head;
		}
		@Override
		public boolean hasNext() {
			return n.next!=null;
		}

		@Override
		public Object next() {
			n=n.next;
			return n.item;
		}
	}

	private class Node {
		public T item;
		public Node next;

		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}


	public boolean isEmpty(){
		return N==0;
	}

	public int size(){
		return N;
	}

	public void enqueue(T t){
		if (last==null){
			last=new Node(t,null);
			head.next=last;
		}else {
			Node oldLast=last;
			last=new Node(t,null);
			oldLast.next=last;
		}
		N++;
	}

	public T dequeue(){
		if (isEmpty()){
			return null;
		}
		Node oldFirst = head.next;
		head.next=oldFirst.next;
		N--;

		if (isEmpty()){
			last=null;
		}
		return oldFirst.item;
	}
}
