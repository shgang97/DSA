package com.shgang.test;

import com.shgang.sort.Student;

public class TestComparable {

	public static void main(String[] args) {
		Student s1 = new Student("张三", 18);
		Student s2 = new Student("李四", 10);
		Student s3 = new Student("王五", 19);

		Comparable max=getMax(s1,s2);
		System.out.println(max);
	}

	public static Comparable getMax(Comparable c1,Comparable c2){
		int result=c1.compareTo(c2);

		if(result>=0){
			return c1;
		}else {
			return c2;
		}
	}
}
