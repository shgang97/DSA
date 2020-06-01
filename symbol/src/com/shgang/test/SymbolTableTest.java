package com.shgang.test;

import com.shgang.symbol.SymbolTable;

public class SymbolTableTest {
	public static void main(String[] args) {
		SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
		symbolTable.put(1,"乔1峰");
		symbolTable.put(2,"乔2峰");
		symbolTable.put(3,"乔3峰");
		symbolTable.put(4,"乔4峰");

		System.out.println(symbolTable.size());

		symbolTable.put(2,"慕容复");
		System.out.println(symbolTable.size());

		symbolTable.put(5,"慕容复5");
		System.out.println(symbolTable.size());


		System.out.println(symbolTable.get(3));
	}
}
