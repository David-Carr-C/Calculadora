package com.calculadora.test;

import com.calculadora.model.OperationTokenizer;
import com.calculadora.model.ReversePolishNotation;
import com.calculadora.model.ShuntingYard;

public class TestShuntingYard {
	public static void main(String[] args) {
		String input = "1 + 2 - 3 * 2.5 * 10 / 10"; //TODO: realizar con not o "-1"
		System.out.println("Infijo: "+OperationTokenizer.tokenizer(input));
		
		ShuntingYard shun = new ShuntingYard(OperationTokenizer.tokenizer(input));
		System.out.println("RPN: "+shun.fromInfijoToRPN());
		
		double result = ReversePolishNotation.executeRPN(shun.fromInfijoToRPN());
		System.out.println("Resultado: "+result);
	}
}
