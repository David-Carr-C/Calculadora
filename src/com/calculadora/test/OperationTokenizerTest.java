package com.calculadora.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculadora.model.OperationTokenizer;
import com.vector.Vector;

class OperationTokenizerTest {
	
	@Test
	void testOperacionSinParentesis() {
		String operation = " 1 + 2 / 10";
		Vector result = OperationTokenizer.tokenizer(operation);
		String r = result.toString();
		assertEquals("1, +, 2, /, 10, " , r);
	}
	
	@Test
	void testOperacionConParentesis() {
		String operation = "( 1 + 2 ) / 8"; // input
		Vector result = OperationTokenizer.tokenizer(operation); // codigo y logica del programa
		String r = result.toString(); // codigo y logica programa
		
		// Lo que yo digo que va a pasar vs lo que hace mi codigo
		assertEquals("(, 1, +, 2, ), /, 8, ", r);
	}
	
	@Test
	void testOperacionConParentesisExtraLarga() {
		String operation = "( 1 + 2 ) / 4 + 2 + 2 - 4 * ( 2 + 2 * 3)";
		Vector result = OperationTokenizer.tokenizer(operation);
		String r = result.toString();
		assertEquals("(, 1, +, 2, ), /, 4, +, 2, +, 2, -, 4, *, (, 2, +, 2, *, 3, ), ", r);
	}
	
	@Test
	void testOperacionCompletaConParentesisGuionBajoYPotencia() {
		String operation = "( 1 + 2 ) / 4 * _3 + (2 ^ 3) - 2";
		Vector result = OperationTokenizer.tokenizer(operation);
		String r = result.toString();
		assertEquals( "(, 1, +, 2, ), /, 4, *, _, 3, +, (, 2, ^, 3, ), -, 2, ", r);
	}
	
	@Test
	void testGodOperation() {
		String operation = "10 * 20 + 3 - 10 * 2 - 10 - 10 * 100 / 25 + 50 + 10 + 500 * 1000";
		String r = OperationTokenizer.tokenizer(operation).toString();
		assertEquals("10, *, 20, +, 3, -, 10, *, 2, -, 10, -, 10, *, 100, /, 25, +, 50, +, 10, +, 500, *, 1000, ", r);
	}
	
	@Test
	void testSenOperation() {
		String operation = "10 * 20 + 3 - 10 * (2+2) + sen(4)";
		String r = OperationTokenizer.tokenizer(operation).toString();
		assertEquals("10, *, 20, +, 3, -, 10, *, (, 2, +, 2, ), +, sen, (, 4, ), ", r);
	}
	
	@Test
	void testCosOperation() {
		String operation = "10 * 20 + 3 - 10 * (2+2) + cos(4)";
		String r = OperationTokenizer.tokenizer(operation).toString();
		assertEquals("10, *, 20, +, 3, -, 10, *, (, 2, +, 2, ), +, cos, (, 4, ), ", r);
	}
	
	@Test
	void testSQRTOperation() {
		String operation = "10 * 20 + 3 - 10 * (2+2) + cos(4) + sqrt4 + 2^2";
		String r = OperationTokenizer.tokenizer(operation).toString();
		assertEquals("10, *, 20, +, 3, -, 10, *, (, 2, +, 2, ), +, cos, (, 4, ), +, sqrt, 4, +, 2, ^, 2, ", r);
	}
	
	@Test
	
	void maybeBreak() {
		String operation = "10 * 20 + 3 - 10 * (2+2) + sen(4) + 4.11110101010192351";
		String r = OperationTokenizer.tokenizer(operation).toString();
		assertEquals("10, *, 20, +, 3, -, 10, *, (, 2, +, 2, ), +, sen, (, 4, ), +, 4.11110101010192351, ", r);
	}

}
