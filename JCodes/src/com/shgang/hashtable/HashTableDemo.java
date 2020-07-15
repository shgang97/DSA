package com.shgang.hashtable;

import java.util.Scanner;

public class HashTableDemo {
	public static void main(String[] args) {
		//创建一个哈希表
		HashTab hashTab = new HashTab(7);
		//写一个简单菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			if (key == "") {
				showMenu();
			}

			key = scanner.next();
			switch (key) {
				case "add":
					System.out.println("请输入id");
					int id = scanner.nextInt();
					System.out.println("请输入名字");
					String name = scanner.next();
					//创建雇员
					Emp emp = new Emp(id, name);
					hashTab.add(emp);
					break;
				case "list":
					hashTab.list();
					break;
				case "exit":
					scanner.close();
					System.exit(0);
					break;
				case "show":
					showMenu();
					break;
				case "find":
					System.out.println("请输入所要查找的员工id：");
					id = scanner.nextInt();
					hashTab.findEmpId(id);
					break;
				default:
					break;
			}
		}
	}

	private static void showMenu() {
		System.out.println("add：添加雇员");
		System.out.println("list：显示成员");
		System.out.println("find：查找员工");
		System.out.println("show：显示菜单");
		System.out.println("exit：退出系统");
	}

}

//表示一个雇员
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

//创建HashTab管理多条链表
class HashTab {
	private EmpLinkedList[] empLinkedListArray;
	private int size;


	//构造器
	public HashTab(int size) {
		this.size = size;
		//初始化empLinkedListArray
		empLinkedListArray = new EmpLinkedList[size];
		//分别初始化每一个链表
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList(i);
		}
	}

	//添加雇员
	public void add(Emp emp) {
		//根据员工的id得到该员工应该添加到哪条链表
		int empLinkedListNo = hashFun(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
	}

	//遍历所有的链表
	public void list() {
		for (int i = 0; i < this.size; i++) {
			empLinkedListArray[i].list();
		}
	}

	//根据id查找员工
	public void findEmpId(int id) {
		int empLinkedLidtNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedLidtNo].findEmpById(id);
		if (emp != null) {
			System.out.printf("id为 %d 的雇员，姓名为 %s ,信息保存在第%d条链表中\n", emp.id, emp.name, empLinkedLidtNo);
		} else {
			System.out.printf("id为 %d 的雇员不存在\n", id);
		}
	}

	//编写一个散列函数
	public int hashFun(int id) {
		return id % size;
	}
}

//创建EpmLinkedList
class EmpLinkedList {
	//头指针，执行第一个Epm，因此我们这个链表的head是直接指向第一个Emp
	private Emp head;
	private int No;

	public EmpLinkedList(int no) {
		this.No = no;
	}

	//添加雇员到链表
	//1.假定，当添加雇员时，id是自增长，即id的分配总是从小到大
	//因此我们将该雇员添加到本链表的最后即可
	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			System.out.println("添加成功");
			return;
		}
		//如果不是第一个雇员，则使用一个辅助指针，定位到最后
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		//退出时直接将emp加入链表
		curEmp.next = emp;
		System.out.println("添加成功");
	}

	//遍历列表的雇员信息
	public void list() {
		System.out.printf("第 %d 条链表，", this.No);
		if (head == null) {
			System.out.println("信息为空");
			return;
		}
		System.out.printf("信息为：\n\t");
		Emp curEmp = head;
		while (true) {
			System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println();
	}

	public Emp findEmpById(int id) {
		Emp curEmp = head;
		while (curEmp != null) {
			if (curEmp.id == id) {
				return curEmp;
			}
			curEmp = curEmp.next;
		}
		return null;
	}
}