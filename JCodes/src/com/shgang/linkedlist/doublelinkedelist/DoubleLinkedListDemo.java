package com.shgang.linkedlist.doublelinkedelist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		DoubleLinkedList alist = new DoubleLinkedList();
		System.out.println("-------------添加节点--------------");
		alist.add(hero1);
		alist.add(hero2);
		alist.add(hero3);
		alist.add(hero4);
//		System.out.println("-------------按顺序添加节点--------------");
//		alist.addByOrder(hero4);
//		alist.addByOrder(hero1);
//		alist.addByOrder(hero3);
//		alist.addByOrder(hero2);
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


	}

}

//定义一个DoubleleLinkedList管理我们的英雄
class DoubleLinkedList {
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
		heroNode.pre = temp;
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
			heroNode.pre = temp;
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

	//从双向链表中删除一个节点
	//直接找到要删除的节点
	public void del(int no) {
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
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println(temp);
			temp.pre.next = temp.next;
			//如果是最后一个节点就不需要执行下面的语句，否则出现空指针异常
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
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
	public HeroNode pre;

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
