package com.calculadora.test;

import stack.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack stack = new Stack();  // TODO: por que al hacer un folder class path y exportar todo en jar no pasa?
		stack.push("Hola");
		System.out.println(stack.peek());
		stack.push("Adios");
		System.out.println(stack.pop());
	}
}
