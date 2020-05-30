package com.shgang.test;

public class CircleLidtCheckTest {

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

		seven.next=third;

		boolean circle=isCircle(first);
		System.out.println("first 链表中是否有环："+circle);
	}

	public static boolean isCircle(Node<String> first) {
		Node<String> fast = first;
		Node<String> slow = first;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast.equals(slow)) {
				return true;
			}
		}
		return false;
	}

	private static class Node<T>{
		T item;
		Node next;

		public Node(T item, Node next){
			this.item=item;
			this.next=next;
		}
	}
}
