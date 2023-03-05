package com.calculadora.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculadora.model.OperationTokenizer;
import com.calculadora.model.ShuntingYard;
import com.vector.Vector;

class ShuntingYardTest {
	@Test
	void testNotacionInfijaAPolacaInversaSinParentesisBasica() {
		Vector v = OperationTokenizer.tokenizer(" 2 + 4");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("2, 4, +, ", resultado);
	}
	
	@Test
	void testNotacionInfijaAPolacaInversaSinParentesisMedia() {
		Vector v = OperationTokenizer.tokenizer(" 2 * 4 + 8 ");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("2, 4, *, 8, +, ", resultado);
	}
	
	@Test
	void testNInfijaARPNSinParentesisAvanzada() {
		Vector v = OperationTokenizer.tokenizer("1 + 2 - 3 * 2.5 * 10 / 10");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("1, 2, +, 3, 2.5, *, 10, *, 10, /, -, ", resultado);
	}
	
	@Test
	void testNotacionInfijaAPolacaInversaParentesisBasica() {
		Vector v = OperationTokenizer.tokenizer(" 2 * (4+ 8)");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("2, 4, 8, +, *, ", resultado);
	}

	
	@Test
	void testDeNotacionInfijaAPolacaInversaConParentesisYResta() { // no permitido: 2 (2 + 2) == 8
		Vector v = OperationTokenizer.tokenizer(" 4 * 9 / 5 * ( 6 - 7 )"); //    7.2  *  -1 == -7.2
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("4, 9, *, 5, /, 6, 7, -, *, ", resultado);
		// 4 9 * 5 / 6 7 - *
		// 36 5 / 6 7 - *
		// 7.2 6 7 - *
		// 7.2 -1 *
		// -7.2
	}
	
	
	@Test
	void testDeNotacionInfijaAPolacaInversaConParentesis() {
		Vector v = OperationTokenizer.tokenizer("20 - ( 4 + 3 ) * 2");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("20, 4, 3, +, 2, *, -, ", resultado);
	}
	
	@Test
	void testDeNotacionInfijaAPolacaInversaConParentesisYRestaYMenosUnitario() { // no permitido: 2 (2 + 2) == 8
		Vector v = OperationTokenizer.tokenizer(" 4 * 9 / 5 * ( 6 - _7 )"); // == 93.6
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("4, 9, *, 5, /, 6, 7, _, -, *, ", resultado);
		// 4 9 * 5 / 6 7 _ - *
		// 36 5 / 6 7 _ - *
		// 7.2 6 7 _ - *
		// 7.2 6 -7 *
		// 7.2 13 *
		// 93.6
	}
	
	@Test
	void wikipedia() {
		Vector v = OperationTokenizer.tokenizer("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
		ShuntingYard sY = new ShuntingYard(v);
		Vector v2 = sY.fromInfijoToRPN();
		String resultado = v2.toString();
		
		assertEquals("3, 4, 2, *, 1, 5, -, 2, 3, ^, ^, /, +, ", resultado);
	}
	
}
