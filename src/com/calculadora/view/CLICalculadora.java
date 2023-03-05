package com.calculadora.view;

import java.util.Scanner;

import com.calculadora.model.Calculadora;

/**
 * Command Line Interface para interactuar con la calculadora y explicar las reglas
 * @author David-Carr-C
 * @version 1.0
 */
public class CLICalculadora {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // prompt from the user
		double result = 0.00; // result to be save
		boolean exit = false; // flag that indicates when the program exit
		String response = "", menu = "- Para usar Exponenciación: 2^2 = 4\n"
				+ "- Para usar Raiz cuadrada: sqrt(4) = 2\n"
				+ "- ¡La calculadora esta en Degrees° (Grados), favor de no utilizar radianes!\n"
				+ "- Para usar Coseno: cos(90) = 0\n"
				+ "- Para usar Seno: sen(180) = 0\n"
				+ "- Tambien se pueden ocupar sqrt y cos y sen sin parentesis\n"
				+ "- Para salir escribe: exit\n"
				+ "¿Cuál operación quieres realizar?: ";
		
		
		do {
			// Input and Output
			System.out.print(menu);
			response = scan.nextLine();
			
			// Exit
			if (response.equals("exit")) {
				exit = true;
				continue; // == break;
			}
			
			// Calc
			Calculadora calc = new Calculadora(response);
			result = calc.calcular();
			
			// Resultados
			System.out.println("\n\n\n\n");
			System.out.println(calc.obtenerRPN());
			System.out.printf("Tu resultado es: %.4f\n\n\n\n", result);
			
			// Condicion de exit
		} while(exit!=true);
		
		
		scan.close(); // close scanner
	}
}
