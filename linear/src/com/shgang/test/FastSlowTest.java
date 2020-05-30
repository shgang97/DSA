package com.shgang.test;

public class FastSlowTest {

	public static void main(String[] args) {
		Node<String> first = new Node<>("aa", null);
		Node<String> second = new Node<>("bb", null);
		Node<String> third = new Node<>("cc", null);
		Node<String> fourth = new Node<>("dd", null);
		Node<String> fifth = new Node<>("ee", null);
		Node<String> six = new Node<>("ff", null);
		Node<String> seven = new Node<>("gg", null);

		first.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		fifth.next=six;
		six.next=seven;

		String mid = getMid(first);
		System.out.println("中间值为："+mid);
	}
	public static String getMid(Node<String> first){
		Node<String> fast=first;
		Node<String> slow=first;

		while (fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow.item;
	}

	private static class Node<T>{
		T item;
		Node next;

		public Node(T item,Node next){
			this.item=item;
			this.next=next;
		}
	}
}
