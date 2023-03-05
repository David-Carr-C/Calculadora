package com.calculadora.model;

/**
 * Recrea la tabla de prioridades de entrada y salida de los operadores, asi como tambien sus representaciones en string
 * @author David-Carr-C
 * @version 1.2
 */
public enum Operadores {
	// Representacion, Entrada, Salida
	SUMA ("+", 1, 1), // operadores binarios
	RESTA ("-", 1, 1),
	MULTIPLICACION ("*", 2, 2),
	DIVISION ("/", 2, 2),
	MENOS_UNITARIO ("_", 3, 3), // operadores unarios
	RAIZ_CUADRADA ("sqrt", 3, 3),
	SENO ("sen", 3, 3),
	COSENO ("cos", 3, 3),
	EXPONENTE ("^", 4, 3), // operadores binarios
	PARENTESIS_APERTURA ("(", 5, 0), // parentesis
	PARENTESIS_CIERRE (")", 100, 100); // tambien se manejaria como '[' y ']'
	
	private final String representation;
	private final int valueEntry;
	private final int valueExit;
	
	Operadores(String representacion, int valueEntry, int valueExit) {
		this.representation = representacion;
		this.valueEntry = valueEntry;
		this.valueExit = valueExit;
	}
	
	public String getRepresentation() {
		return this.representation;
	}
	
	public int getValueEntry() {
		return valueEntry;
	}
	
	public int getValueExit() {
		return valueExit;
	}
}
