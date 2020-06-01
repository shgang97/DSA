package com.shgang.test;

import com.shgang.symbol.OrderSymbolTable;

public class OldSymbolTableTest {
	public static void main(String[] args) {
		OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
		table.put(1,"张三");
		table.put(1,"李四");
		table.put(1,"赵六");
		table.put(1,"田七");

		table.put(3,"王五");
	}
}
