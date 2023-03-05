package com.calculadora.controller;

import com.calculadora.model.Calculadora;

/**
 * Maneja el modelo y lo expresa de mejor manera para mostrarlo por la vista
 * @author David-Carr-C
 * @version 1.0
 */
public class OperationExecute {
	public static String executeCalculadora(String expression) {
		Calculadora calc = new Calculadora(expression);
		double result = calc.calcular();
		
		// Not exact cos and sen in degrees
		if (result < 0.000000000000002 && result > 0) { // menos que 0.0000000002 y mayor que 0, para no dañar negativos
			result = 0; // round
		}
		
		Double res = result; // permitir que el resultado se vuelva
		return res.toString(); // string
	}
}
