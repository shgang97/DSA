package com.shgang.test;

import com.shgang.linear.SequenceList;

public class SequenceListTest {
	public static void main(String[] args) {
		SequenceList<String> s1 = new SequenceList<>(10);
		s1.insert("姚明");
		s1.insert("科比");
		s1.insert("麦迪");
		s1.insert(1,"詹姆斯");

		for (String s : s1) {
			System.out.println(s);
		}

		System.out.println("-------------------");

		for (int i=0;i<=s1.length();i++){
			System.out.println(s1.get(i));
		}
	}
}
