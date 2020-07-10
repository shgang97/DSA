package com.shgang.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//将中缀表达式转成对应的List
public class InfixToSuffix {
	public static void main(String[] args) {
		String expression = "1+((2+3)*4)-5";
		List<String> list = infixToList(expression);
		System.out.println(list);
		List<String> suffix = infixToSuffix(expression);
		System.out.println(suffix);
		System.out.println(expression+"="+PolandNotation.calculate(suffix));
	}

	//方法：将得到的中缀表达式对应的List转成后缀表达式对应的List
	public static List<String> infixToSuffix(String s) {
		List<String> list = infixToList(s);
		/**
		 * 1)初始化两个栈：运算符栈s1和储存中间结果的栈s2；
		 * 2)从左至右扫描中缀表达式；
		 * 3)遇到操作数时，将其压s2；
		 * 4)遇到运算符时，比较其与s1栈顶运算符的优先级：
		 *   (1)如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
		 *   (2)否则，若优先级比栈顶运算符的高，也将运算符压入s1；
		 *   (3)否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较
		 * 5)遇到括号时： (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
		 * 6)重复步骤2至5，直到表达式的最右边
		 * 7)将s1中剩余的运算符依次弹出并压入s2
		 * 8)依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
		 */
		List<String> suffixList = new ArrayList<>();
		Stack<String> operStack = new Stack<>();
		String str;
		for (String item : list) {
			//如果满足一个数，加入数组
			if (item.matches("\\d+")) {
				suffixList.add(item);
			} else if (item.equals("(")) {
				operStack.push(item);
			} else if (item.equals(")")) {
				while (!operStack.peek().equals("(")) {
					suffixList.add(operStack.pop());
				}
				operStack.pop();//将做括号弹出
			} else {
				while (true) {
					if (operStack.isEmpty() || operStack.peek().equals("(") || priority(item) > priority(operStack.peek())) {
						operStack.push(item);
						break;
					} else {
						suffixList.add(operStack.pop());
					}
				}
			}
		}
		while (!operStack.isEmpty()) {
			suffixList.add(operStack.pop());
		}
		return suffixList;
	}

	//方法：将中缀表达式转成对应的List
	public static List<String> infixToList(String s) {
		//定义一个list用于存放对应的内容
		List<String> list = new ArrayList<>();
		int i = 0;
		String str;
		char c;
		do {
			//如果c是一个非数字，就需要加到ls中去
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				list.add("" + c);
				i++;
			} else {//如果是一个数字，就需要考虑多位数
				str = "";//先将str置成空串
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				list.add(str);
			}

		} while (i < s.length());
		return list;
	}

	//方法：比较运算符优先级
	public static int priority(String oper) {
		if (oper == "*" || oper == "/") {
			return 1;
		} else if (oper == "+" || oper == "-") {
			return 0;
		} else {
			return -1;
		}
	}
}
