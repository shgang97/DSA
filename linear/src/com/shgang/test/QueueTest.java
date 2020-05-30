package com.shgang.test;

import com.shgang.linear.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");

		for (String str : q) {
			System.out.println(str);
		}
		System.out.println("------------------");

		String result = q.dequeue();
		System.out.println("出队列的元素"+result);
	}
}
