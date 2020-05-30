package com.shgang.test;

import com.shgang.linear.Stack;

public class BracketsMatchTest {

	public static void main(String[] args) {
		String str ="(上海(长安)()";
		boolean match = isMatch(str);
		System.out.println(match);
	}
	public static boolean isMatch(String str){
		Stack<String> chars = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			String currChar = str.charAt(i) + "";

			if (currChar.equals("(")){
				chars.push(currChar);
			}else if (currChar.equals(")")){
				String pop=chars.pop();
				if (pop==null){
					return false;
				}
			}
		}
		if (chars.size()==0){
			return true;
		}else {
			return false;
		}
	}
}
