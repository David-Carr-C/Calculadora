package com.calculadora.model;

import com.vector.Vector;

/**
 * Abstrae la necesidad de crear una instancia de la clase ShuntingYard para que simplemente se pase el vector 
 * y se obtenga la expresion RPN
 * @author David-Carr-C
 * @version 1.0
 */
public class FacadeShuntingYard {
	public static Vector fromInfijoToRPN(Vector tokensExpressionInfija) {
		ShuntingYard shuntingYard = new ShuntingYard(tokensExpressionInfija);
		return shuntingYard.fromInfijoToRPN();
	}
}
