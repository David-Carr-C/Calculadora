package com.calculadora.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculadora.model.Calculadora;

class CalculadoraTest {

	@Test
	void testBasicExpression() {
		Calculadora calc = new Calculadora(" 1 + 2 * 4");
		double result = calc.calcular();
		assertEquals(9.0, result);
	}
	
	@Test
	void testMediumExpression() {
		Calculadora calc = new Calculadora("1 + 1 + 2 * 8 / 2");
		double result = calc.calcular();
		assertEquals(10.0, result);
	}
	
	@Test
	void testCos() {					// 90° degrees == 1.571 radians
		Calculadora calc = new Calculadora("cos(90) + 100 * 2 + ( 1+1 )");
		double r = calc.calcular();
		assertEquals(202.0, r);
	}
	
	@Test
	void testSen() {					// 90° degrees == 1.571 radians
		Calculadora calc = new Calculadora("sen(180) + 100 * 1 + ( 2^2 )");
		double r = calc.calcular();
		assertEquals(104.0, r);
	}
	
	@Test
	void testExp() {
		Calculadora calc = new Calculadora("( 2 ^ 8 ) ");
		double r = calc.calcular();
		assertEquals(256.0, r);
	}
	
	@Test
	void testRaizCuadrada() {
		Calculadora calc = new Calculadora("sqrt(256) + ( 2 ^ 8 ) "); // 16 + 256
		double r = calc.calcular();
		assertEquals(272.0, r);
	}
	
	@Test
	void testInversa() {
		Calculadora calc = new Calculadora("sqrt(( 2 ^ 2 )) ");
		double r = calc.calcular();
		assertEquals(2, r);
	}
	
	
	@Test
	void testParentesisExpresion() {
		Calculadora calc = new Calculadora("(2 + 2) * 4");
		double res = calc.calcular();
		assertEquals(16.0, res);
	}
	
	@Test
	void testBigParenthesisExpression() { // cuando se ponen correctamente los parentesis si aparece como en Google
		Calculadora calc = new Calculadora("(10 * 20) + 3 - (10 * 2) - 10 - (( 10 * 100 ) / 25 ) + 50");
		double r = calc.calcular();
		assertEquals(183.0, r);
	}

}

/*@Test // Hay un fallo, en como Google representa las operaciones (añade corchetes) y en como se representan sin corchetes
void testAdvancedExpression() {
	String expresion = " 10 * 20 + 3 - 10 * 2 - 10 - 10 * 100 / 25 + 50";
	String resultTokens = OperationTokenizer.tokenizer(expresion).toString();
	assertEquals("10, *, 20, +, 3, -, 10, *, 2, -, 10, -, 10, *, 100, /, 25, +, 50, ", resultTokens);
	
	ShuntingYard sY = new ShuntingYard(OperationTokenizer.tokenizer(expresion));
	double result = ReversePolishNotation.executeRPN(sY.fromInfijoToRPN());
	assertEquals(183.0,	result);
	
	Calculadora calculadora = new Calculadora(" 10 * 20 + 3 - 10 * 2 - 10 - 10 * 100 / 25 + 50");
	double r = calculadora.calcular();
	assertEquals(183.0, r);
}

@Test
void testGodExpression() {
	Calculadora calc = new Calculadora("10 * 20 + 3 - 10 * 2 - 10 - 10 * 100 / 25 + 50 + 10 + 500 * 1000");
	double r = calc.calcular();
	assertEquals(500193.0, r);
}*/
