package com.shgang.linkedlist.singlelinkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		SingleLinkedList alist = new SingleLinkedList();
//		alist.add(hero1);
//		alist.add(hero2);
//		alist.add(hero3);
//		alist.add(hero4);
		System.out.println("-------------按顺序添加节点--------------");
		alist.addByOrder(hero4);
		alist.addByOrder(hero1);
		alist.addByOrder(hero3);
		alist.addByOrder(hero2);
		alist.list();
		System.out.println("-------------修改节点--------------");
		HeroNode newHero = new HeroNode(2, "小卢", "玉麒麟");
		alist.update(newHero);
		alist.list();
		System.out.println("-------------删除节点--------------");
		alist.del(1);
//		alist.del(2);
//		alist.del(3);
//		alist.del(4);
//		alist.del(4);
		alist.list();
		System.out.println("-------------获取有效节点个数--------------");
		System.out.println(getLength(alist.getHead()));
		System.out.println("-------------获取倒数第2个节点--------------");
		System.out.println(getLastIndexNode(alist.getHead(), 2));
		System.out.println("-------------反转列表--------------");
		reverseList(alist.getHead());
		alist.list();
		System.out.println("-------------递归法逆序打印列表--------------");
		postPrint(alist.getHead());
		System.out.println("-------------使用栈逆序打印列表--------------");
		reversPrint(alist.getHead());


	}


	//exer1:获取单链表节点的个数

	/**
	 * @param head 链表的头节点
	 * @return 返回有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while (cur != null) {
			length += 1;
			cur = cur.next;
		}
		return length;
	}


	//exer2:查找单链表中单数第k个节点
	public static HeroNode getLastIndexNode(HeroNode head, int index) {
		if (head.next == null || index <= 0) {
			return null;
		}
		int size = getLength(head);
		if (index > size) {
			return null;
		}
		HeroNode cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}


	//exer3:单链表反转
	public static void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}
		//定义一个辅助的指针
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while (cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
	}

	//exer4_1递归法:逆序打印节点
	public static void postPrint(HeroNode head) {
		HeroNode cur = head.next;
		if (cur == null) {
			return;
		} else {
			postPrint(cur);
			System.out.println(cur);
		}
	}

	//exer4_2使用栈法:逆序打印节点
	public static void reversPrint(HeroNode head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<>();
		HeroNode cur = head.next;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}

//定义一个SingleLinkedList管理我们的英雄
class SingleLinkedList {
	//	先初始化一个头节点，头节点不要动
	private HeroNode head = new HeroNode(0, "'", "");


	//添加节点的单向链表
	//思路，当不考虑编号的顺序时
	//1.找到当前链表的最后节点
	//2.将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode) {
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while (true) {
			//找到链表的最后
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		//当退出while循环时，temp指向了链表的最后
		temp.next = heroNode;
	}

	//第二种添加英雄的方法，按照排名将英雄添加到指定位置
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//判断flag的值
		if (flag) {
			System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n", heroNode.no);

		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	//显示链表
	public void list() {
		//判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while (true) {
			//判断链表是否到最后
			if (temp == null) {
				break;
			}
			//输出节点信息
			System.out.println(temp);
			//将next后移
			temp = temp.next;
		}
	}

	//修改节点的信息，根据no编号来修改，即no不能改
	public void update(HeroNode newHeroNode) {
		//判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {//没有找到
			System.out.printf("没有找到编号为%d的节点", newHeroNode.no);
		}
	}

	//删除节点
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				System.out.println("链表为空");
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("没有找到编号为%d的节点", no);
		}

	}

	public HeroNode getHead() {
		return head;
	}
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	//重写toString方法
	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				'}';
	}

	//构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
}
