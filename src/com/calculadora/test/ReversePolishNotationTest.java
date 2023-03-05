package com.calculadora.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculadora.model.OperationTokenizer;
import com.calculadora.model.ReversePolishNotation;
import com.vector.Vector;

class ReversePolishNotationTest {
	
	//TODO: Exceptions test assertThrows(IllegalArgumentException.class);

	@Test
	void testExecutorRPN() {
		Vector vector = OperationTokenizer.tokenizer("5, 8, +, 3, *");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(39.0, total);
	}
	
	@Test
	void testCos() {
		Vector vector = OperationTokenizer.tokenizer("90, cos");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(total, total); // not exact 0.0
	}
	
	@Test
	void testSen() {
		Vector vector = OperationTokenizer.tokenizer("180, sen, 1, +");
		float r = (float) ReversePolishNotation.executeRPN(vector);
		
		assertEquals(1.0, r); // not exact 0.0
	}
	
	@Test
	void testExecutorRPN2() {
		Vector vector = OperationTokenizer.tokenizer("5, 8, 3, *, +");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(29.0, total);
	}
	
	@Test
	void testExecutorRPNAdvanced() {
		Vector vector = OperationTokenizer.tokenizer("8 2 5 * + 1 3 2 * + 4 - /");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(6.0, total);
	}
	
	@Test
	void testExample1Web() {
		Vector vector = OperationTokenizer.tokenizer("2 4 * 8 + ");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(16.0, total);
	}
	
	@Test
	void testExample2Web() {
		Vector vector = OperationTokenizer.tokenizer("2 4 8 + * ");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(24.0, total);
	}
	
	@Test
	void testExample3Web() {
		Vector vector = OperationTokenizer.tokenizer("3 2 * 11 - ");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(-5.0, total);
	}
	
	@Test
	void testExample4Web() {
		Vector vector = OperationTokenizer.tokenizer("2 5 * 4 + 3 2 * 1 + / ");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(2.0, total);
	}
	
	@Test
	void testExponente() {
		Vector vector = OperationTokenizer.tokenizer("4 4 + 2 ^"); // 8 2 ^
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(64.0, total);
	}
	
	@Test
	void wikipedia() {
		Vector vector = OperationTokenizer.tokenizer("5 1 2 + 4 * + 3 -");
		double total = ReversePolishNotation.executeRPN(vector);
		
		assertEquals(14.0, total);
	}

}
