package com.shgang.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
//		String suffixExpression = "3 4 + 5 * 6 -";
		String suffixExpression = "30 4 + 5 * 6 -";
		List<String> rpnList = getListSring(suffixExpression);
		System.out.println("rpnList = " + rpnList);
		int res = calculate(rpnList);
		System.out.println("计算结果："+res);

	}

	//将一个你波兰表达式依次将数据和运算符放入到ArrayList中
	public static List<String> getListSring(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		ArrayList<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}
	//完成对你波兰表达式的计算

	/**
	 * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，
	 * 遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈；
	 * 重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
	 * <p>
	 * <p>
	 * "3 4 + 5 * 6 -"
	 * 从左至右扫描，将3和4压入堆栈；
	 * 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
	 * 将5入栈；
	 * 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
	 * 将6入栈；
	 * 最后是-运算符，计算出35-6的值，即29，由此得出最终结果
	 */
	public static int calculate(List<String> ls) {
		Stack<String> stack = new Stack<>();
		//遍历ls
		for (String item : ls) {
			if (item.matches("\\d+")) {
				stack.push(item);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = calculate(item, num1, num2);
				stack.push(Integer.toString(res));
			}
		}
		return Integer.parseInt(stack.pop());
	}

	public static int calculate(String oper, int num1, int num2) {
		if (oper.equals("+")) {
			return num1 + num2;
		} else if (oper.equals("-")) {
			return num1 - num2;
		} else if (oper.equals("*")) {
			return num1 * num2;
		} else if (oper.equals("/")) {
			return num1 / num2;
		} else {
			throw new RuntimeException("符号错误～～");
		}

	}
}
