package com.shgang.stack;

public class Calculator {
	public static void main(String[] args) {
		String expression = "300+20*6*4/2-200";
		//创建两个栈：数盏，符号栈
		CalStack numStack = new CalStack(10);
		CalStack operStack = new CalStack(10);
		//定义需要的相关变量
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
//			System.out.println(ch);
			if (operStack.isOper(ch)) {
				//判断当前的符号栈是否为空
				if (operStack.isEmpty()) {
					operStack.push(ch);
				} else {
					//如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
					//再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//把计算结果入数栈
						numStack.push(res);
						System.out.printf("%d %c %d = %d\n", num2, oper, num1, res);
						//把当前操作符入符号栈
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
				}
			} else {//如果是数，则直接入数栈
				//分析思路
				//1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
				//2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
				//3. 因此我们需要定义一个变量 字符串，用于拼接
				keepNum += ch;
				if (index == expression.length() - 1) {
					//数字数字符的ascii码相差48
					numStack.push(Integer.parseInt(keepNum));
					System.out.println("数字直接入栈" + Integer.parseInt(keepNum));
				} else {
					//判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					//注意是看后一位，不是index++
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						System.out.println("数字直接入栈" + Integer.parseInt(keepNum));
						keepNum = "";
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		while (true) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
			System.out.printf("%d %c %d = %d\n", num2, oper, num1, res);
		}
		System.out.printf("表达式%s = %d", expression, numStack.pop());
	}
}

class CalStack extends ArrayStack {

	public CalStack(int maxSize) {
		super(maxSize);
	}

	//返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
	//数字越大则优先级就越高
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	//计算方法
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num2 + num1;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num2 * num1;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}
}
