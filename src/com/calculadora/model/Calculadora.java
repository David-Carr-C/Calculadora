package com.calculadora.model;

import com.vector.Vector;

/**
 * Convierte la expresion en tokens los cuales seran evaluados con el algoritmo ShuntingYard, el cual convierte la 
 * expresion en Notacion Polaca Inversa, y al final se ejecuta esta expresion para tener el resultado de la operacion
 * @author David-Carr-C
 * @version 1.0
 */
public class Calculadora {
	private String input;
	
	public Calculadora(String input) {
		this.input = input;
	}
	
	public double calcular() { //TODO: Hacer facade de todo esto?
		Vector tokens = OperationTokenizer.tokenizer(this.input); // tokenizamos la expresion infija recibida
		Vector expression = FacadeShuntingYard.fromInfijoToRPN(tokens); // pasamos los tokens a expresion rpn
		return ReversePolishNotation.executeRPN(expression); // ejecutamos la expresion rpn
	}
	
	public String obtenerRPN() {
		Vector tokens = OperationTokenizer.tokenizer(this.input); // tokenizamos la expresion infija recibida
		return FacadeShuntingYard.fromInfijoToRPN(tokens).toString(); // pasamos los tokens a expresion rpn
	}
}
