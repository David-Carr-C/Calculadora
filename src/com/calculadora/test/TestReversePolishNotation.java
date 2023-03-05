package com.calculadora.test;

import com.calculadora.model.OperationTokenizer;
import com.calculadora.model.ReversePolishNotation;
import com.vector.Vector;

public class TestReversePolishNotation {
	public static void main(String[] args) {
		Vector vector = OperationTokenizer.tokenizer("5, 8, +, 3, *");
		System.out.println(vector);
		double total = ReversePolishNotation.executeRPN(vector);
		System.out.println("El total de \"5 8 + 3 *\" es: "+total);
		
		vector = OperationTokenizer.tokenizer("5, 8, 3, *, +");
		System.out.println(vector);
		total = ReversePolishNotation.executeRPN(vector);
		System.out.println("El total de \"5 8 3 * +\" es: "+total);
		
		vector = OperationTokenizer.tokenizer("8 2 5 * + 1 3 2 * + 4 - /");
		System.out.println(vector);
		total = ReversePolishNotation.executeRPN(vector);
		System.out.println("El total de \" 8 2 5 * + 1 3 2 * + 4 - / \" es: "+total);
	}
}
