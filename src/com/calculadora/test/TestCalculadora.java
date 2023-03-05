package com.calculadora.test;

import com.calculadora.model.Calculadora;

public class TestCalculadora {
	public static void main(String[] args) {
		String input = "1 + 2 - 3 * 2.5 * 10 / 10"; //TODO: realizar con not o "-1"
		Calculadora calculadora = new Calculadora(input);
		System.out.println(calculadora.calcular());
	}
}
