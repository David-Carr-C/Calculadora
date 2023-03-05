package com.calculadora.model;

import com.vector.Vector;

import stack.Stack;

/**
 * Algoritmo que cambia una expresion Infija a una Postfija o RPN (Reverse Polish Notation)
 * @author David-Carr-C
 * @version 1.2
 */
public class ShuntingYard {
	private Vector expressionInfija;
	private Vector expressionRPN;
	private Stack stackOperador;
	private int positionRPN;
	
	public ShuntingYard (Vector expressionInfija) {
		// TODO: Mucha logica para que solo sea procedural/static o envolverlo en un Facade para que sea static
		this.positionRPN = 0; // posicion en la que iremos guardando los valores
		this.expressionInfija = expressionInfija; // expresion infija que sera convertida a postfija
		this.expressionRPN = new Vector(); // es el vector que contendra la expresion final, se le ira añadiendo
		  								   // operandos y operadores cuando sea necesario
		this.stackOperador = new Stack(); // este stack solo admite operadores y se basara en la logica asignada
	}
	
	/**
	 * Transforma una expresion infija en una expresion Reverse Polish Notation
	 * @param expressionInfija Un vector que contiene todos los tokens de la expresion infija
	 * @return expressionRPN
	 */
	public Vector fromInfijoToRPN() {
		if (expressionInfija.isEmpty()) // da excepcion si el string que nos pasaron estaba vacia
			throw new IllegalArgumentException("Fallo, la expresion infija esta vacia");
		
		for (int i = 0; i < expressionInfija.getInnerItemSize(); i++) {
			String el = expressionInfija.getEle(i).toString(); // elemento i de la expresion infija
			
			if (el.equals("[")) el = "("; // transforma [ to (
			if (el.equals("]")) el = ")"; // transforma ] to )
			
			// Si la pila esta vacia (aun no hay parentesis de apertura) lanza exception
			if (el.equals(")") && stackOperador.isEmpty())
				throw new IllegalArgumentException("Cerraste un parentesis o corchete sin abrir uno");
			
			// Si es operador (revisa) hace pop al stack (mete lo salido al rpn) y luego hace push al operador 
			// revisamos si no esta vacio para tener un elemento al cual hacer pop y checar cual es mayor
			if (el.equals("*") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.MULTIPLICACION);
			} else if (el.equals("/") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.DIVISION);
			} else if (el.equals("+") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.SUMA);
			} else if (el.equals("-") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.RESTA);
			} else if (el.equals("(") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.PARENTESIS_APERTURA);
			} else if (el.equals(")") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.PARENTESIS_CIERRE);
			} else if (el.equals("_") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.MENOS_UNITARIO);
			} else if (el.equals("sqrt") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.RAIZ_CUADRADA);
			} else if (el.equals("sen") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.SENO);
			} else if (el.equals("cos") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.COSENO);
			} else if (el.equals("^") && !stackOperador.isEmpty()) {
				whichIsBigger(Operadores.EXPONENTE);
			}
			
			// No validamos el ")" debido a que necesita estar llena la pila para cerrarse un parentesis
			if (stackOperador.isEmpty() && (el.equals("*") || el.equals("/") || el.equals("+") || el.equals("-") || el.equals("(")
					|| el.equals("_") || el.equals("sqrt") || el.equals("sen") || el.equals("cos")
					|| el.equals("^"))) { // Remember, en sentencias grandes hay que usar parentesis para el &&
				// Si conecta con operador y esta vacio el stack entonces se hace push al Stack
				stackOperador.push(el);
			}
			
			// Si es operando se pasa al vector RPN
			if ( !el.equals("*") && !el.equals("/") && !el.equals("+") && !el.equals("-") && !el.equals("(")
					&& !el.equals("_") && !el.equals("sqrt") && !el.equals("sen") && !el.equals("cos")
					&& !el.equals("^") && !el.equals(")")) { // Aqui si hace falta validar )
				// Podemos saber que no es operador de la comparacion de arriba, cuando no es igual a ningun operador
				expressionRPN.altaPos(positionRPN, el);
				positionRPN++; // se aumenta en 1 la variable para ir insertando en la expresion al final
			} 
			
		}
		
		// Si el stack esta aun con elementos entonces se vacia y los elementos pasan al RPN
		while (!stackOperador.isEmpty()) {           // Si se descubre "(" es que no se cerro el parentesis
			if (stackOperador.peek().equals("(")) throw new IllegalArgumentException("No cerro parentesis");
			expressionRPN.altaPos(positionRPN, stackOperador.pop());
			positionRPN++;
		}
		
		return expressionRPN; // regresa el RPN
	}
	
	/**
	 * Se visualizara el top del stack de operadores para poder entregar en el siguiente methodo {@code theBigOne}
	 * tanto el operador del top del stack como el operador que se desea ejecutar
	 * @param operador Operador a ser juzgado (viene de la expresion infija)
	 * @throws IllegalArgumentException cuando hay parentesis de cierre pero no de apertura
	 */
	private void whichIsBigger(Operadores operador) {// + - * / ( ) ^ cos sen sqrt _
		
		// Si es parentesis de cierre elimina el otro parentesis de apertura
		if (operador.getRepresentation().equals(")")) {
			String var = "";
			
			try {
				// Se vacia el stack hasta que el operador sea igual a "("
				while (  !(var = stackOperador.pop().toString()).equals("(")) {
					expressionRPN.altaPos(positionRPN, var);
					positionRPN++;
				}
				
			} catch (Exception e) {
				System.err.println("Solo pusiste parentesis de apertura, no de cierre");
			}
			
			if (var.equals("(")) {
				return; // cuando se saca ( del stack entonces se termina de analizar el caso de operador.PARENTESIS_CIERRE
			}
			
		}
		
		// En base a enums decidir cual tiene mas peso (el stack.pop o el operador) y saber si hacer push
		// o pop. claro si se hace push se agrega al rpn lo que habia en top y despues se pushea el elemento
		if (Operadores.SUMA.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.SUMA, operador); // si es suma se va al metodo
		} else if (Operadores.RESTA.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.RESTA, operador); // si es resta se va al metodo
		} else if (Operadores.MULTIPLICACION.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.MULTIPLICACION, operador); // si es multiplicacion va al metodo
		} else if (Operadores.DIVISION.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.DIVISION, operador); // si es division va al metodo
		} else if (Operadores.PARENTESIS_APERTURA.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.PARENTESIS_APERTURA, operador); // si es parentesis apertura va al metodo
		} else if (Operadores.SENO.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.SENO, operador);
		} else if (Operadores.COSENO.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.COSENO, operador);
		} else if (Operadores.EXPONENTE.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.EXPONENTE, operador);
		} else if (Operadores.MENOS_UNITARIO.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.MENOS_UNITARIO, operador);
		} else if (Operadores.RAIZ_CUADRADA.getRepresentation().equals(stackOperador.peek())) {
			theBigOne(Operadores.RAIZ_CUADRADA, operador);
		}
	}
	
	/**
	 * Realiza una comparacion de operadores para conocer quien debe entrar al vector de operadores
	 * y quien debe ir al rpn
	 * @param operadorDelStack Cima del stack de operadores
	 * @param operadorAEntrar Operador elemento de la expresion infija
	 */
	private void theBigOne(Operadores operadorDelStack, Operadores operadorAEntrar) {
		
		// Si es mayor el operadorAEntrar entra directo
		if (operadorAEntrar.getValueEntry() > operadorDelStack.getValueExit())
			stackOperador.push(operadorAEntrar.getRepresentation()); // entra directo
		
		// Si es menor se hace pop (pasa al rpn) y entra el operador
		else if (operadorAEntrar.getValueEntry() < operadorDelStack.getValueExit()) {
			// Se añade el operador del stack al RPN
			expressionRPN.altaPos(this.positionRPN, stackOperador.pop()); // antes de entrar deje pasar
			stackOperador.push(operadorAEntrar.getRepresentation()); // entra el operador
			positionRPN++;
		}
		
		// Si son iguales es como si fuera menor
		else if (operadorAEntrar.getValueEntry() == operadorDelStack.getValueExit()) {
			// Se añade el operador del stack al RPN
			expressionRPN.altaPos(this.positionRPN, stackOperador.pop()); // antes de entrar deje pasar
			stackOperador.push(operadorAEntrar.getRepresentation()); // entra el operador
			positionRPN++;
		}
	}
}









