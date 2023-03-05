package com.calculadora.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vector.Vector;

/**
 * Separa cualquier string en sus operandos y operadores
 * @author David-Carr-C
 * @version 1.3
 */
public class OperationTokenizer {
	// Regex que busca números o uno de los siguientes operadores o paréntesis: +, -, *, /, (, ), [, ], _, ^ o sen o cos
	private static final String REGEX = "[0.0-9.9]+|[\\+\\-\\*\\/\\(\\)\\[\\]\\_\\^]|(cos)|(sen)|(sqrt)";
	
	/**
	 * Se separara la string en diferentes tokens para nuestras operaciones matematicas, con ello tenemos que
	 * compilar {@code REGEX} para separar cualquier cadena en operadores y operandos
	 * @param operationToBeSplited
	 * @return tokens
	 */
	public static Vector tokenizer(String operation) {
		Vector tokens = new Vector(); // vector en ser retornado y que contendra los tokens
		Pattern pattern = Pattern.compile(REGEX); // compila el patron regex
		Matcher matcher = pattern.matcher(operation); // crea un matcher del patron con el string que se desea separar
		int i = 0;
		while (matcher.find()) { // se buscan secuencias que coincidan con el patron
			tokens.altaPos(i,matcher.group()); // recupera la secuencia que coincide con el patron
			i++; // aumenta en 1 para ir agregando, en este indice, los elementos al vector de tokens
		}
		return tokens;
	}
	
	/*
	La expresión regular "[0-9]+|[\\+\\-\\*\\/\\(\\)\\[\\]]" es utilizada en el código para separar una expresión 
	matemática en tokens.

	Una expresión regular es una secuencia de caracteres que describe un patrón de búsqueda en una cadena de texto.
	En Java, se pueden utilizar expresiones regulares con la clase java.util.regex.Pattern.

	El patrón regular en este caso busca dos cosas:

	1.- Secuencias de uno o más dígitos (números flotantes) utilizando [0.0-9.9]+.

	2.- Uno de los siguientes caracteres: +, -, *, /, (, ), [, ], _ utilizando [\\+\\-\\*\\/\\(\\)\\[\\]\\_].

	El símbolo | es el operador lógico OR, que significa que se buscará cualquiera de las dos cosas descritas 
	anteriormente.

	La clase java.util.regex.Matcher se utiliza para buscar el patrón en una cadena de texto y para recuperar 
	los resultados de la búsqueda. En este código, se crea un matcher con la expresión matemática que se 
	desea separar en tokens y luego se utiliza el método find para buscar secuencias que coincidan con el patrón.
	Cada vez que se llama al método find, el matcher avanza a la siguiente coincidencia en la cadena de texto. 
	El método group se utiliza para recuperar la secuencia que coincide con el patrón.
	
	Los parentesis () se ocupan para crear grupos de captura, por lo cual captura todo un bloque como: (word) -> word
	Mientras que los corchetes [] son posiciones por lo tanto es mas desmenusado como: [word] -> w,o,r,d
	
	-- Versiones --
	
	Version 1.1 Se cambio 0 por 0.0 y 9 por 9.9 para tambien capturar decimales
	
	Version 1.2 Se añadieron ^ y _
	
	Version 1.3 cos y sen y sqrt
	*/
}
