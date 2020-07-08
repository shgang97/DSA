package com.shgang.linkedlist.singlecirclelinkedlist;

public class Josepfu {
	public static void main(String[] args) {
		CircleSingleLinkedList clist = new CircleSingleLinkedList();
		clist.addBoy(5);
		System.out.println("------------------查看链表---------------------");
		clist.showBoy();
		System.out.println("------------------约瑟夫问题出圈顺序---------------------");
		clist.countBoy(1, 2, 5);
	}
}

//创建一个单向环形链表
class CircleSingleLinkedList {
	//创建一个first节点，当前没有编号
	private Boy first = new Boy(-1);

	//添加小孩节点，构建一个环形链表
	public void addBoy(int nums) {
		//nums做数据校验
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	//遍历当前的环形链表
	public void showBoy() {
		//判断链表是否为空
		if (first == null) {
			System.out.println("没有任何小孩～～");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号%d\n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}

	}

	//根据用户输入，计算小孩出圈的顺序

	/**
	 * @param startNo  表示从第几个小孩开始数数
	 * @param countNum 表示数几下
	 * @param nums     表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		//先进行数据校验
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		//创建辅助指针，帮助完成小孩出圈
		Boy helper = first;
		//事先应该让helper这个指针指向环形链表最后这个节点
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
//		System.out.println("helper = " + helper.getNo() + "first = " + first.getNo());
		//小孩报数前，先让first和helper移动到开始位置
		for (int j = 0; j < startNo - 1; j++) {
			helper = helper.getNext();
			first = first.getNext();
		}
//		System.out.println("helper = " + helper.getNo() + "first = " + first.getNo());
		while (true) {
			if (helper == first) {//说明圈中只有一个节点
				break;
			}
			//让first和helper指针同时移动countNum-1次
//			System.out.printf("开始数数的小孩编号：%d", first.getNo());
			for (int i = 0; i < countNum - 1; i++) {
				helper = helper.getNext();
				first = first.getNext();
			}
			System.out.printf("小孩%d出圈\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("留在圈中的小孩编号为：%d\n", first.getNo());
	}
}

//创建一个Boy类，表示一个节点
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}
