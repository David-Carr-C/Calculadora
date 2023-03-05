package com.calculadora.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vector.Vector;

import stack.Stack;

/**
 * Evalua las expresiones postfijas o Notacion Polaca Inversa
 * @author David-Carr-C
 * @version 1.0
 */											 	// v regex literal
public class ReversePolishNotation {	//		  / \+ / <- regex
	private static Pattern regexSum = Pattern.compile("\\+"); // no hacen falta corchetes porque no son varias clases de regex
	private static Pattern regexMulti = Pattern.compile("\\*");
	private static Pattern regexDivision = Pattern.compile("\\/");
	private static Pattern regexMenosUnitario = Pattern.compile("\\_");
	private static Pattern regexRaizCuadrada = Pattern.compile("(sqrt)");
	private static Pattern regexSeno = Pattern.compile("(sen)");
	private static Pattern regexCoseno = Pattern.compile("(cos)");
	private static Pattern regexExponente = Pattern.compile("\\^");
	
	/**
	 * Se evalua la siguiente expresion regular '-?\d+(\.\d+)?' donde '-?' quiere decir que opcionalmente puede haber
	 * un menos, despues '\d' representa cualquier digito entero, despues '+' indica que debe aparecer uno o más veces,
	 * a su vez el grupo de captura '(\.\d+)?' indica que opcionalmente (dado a que tiene al final un '?') puede haber
	 * una expresion que tenga decimal '\.' y uno o mas digitos enteros.
	 */
	private static Pattern regexNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
		
	/**
	 * Tendremos un VectorRPN el cual ira metiendo al stackEvaluador operandos y operadores pero al
	 * encontrar un operador se checan los 2 elementos detras y se realiza la operacion con el operador 
	 * y con los dos elementos. Se vuelve a la stack el resultado obtenido
	 * @param vectorRPN Expresión RPN (Notacion Polaca Inversa)
	 * @return variable acumulada
	 */
	public static double executeRPN(Vector vector) {
		double acumulador = 0.00; // variable a retornar y que ocuparemos para guardar los resultados
		
		Stack stackEvaluador = new Stack(); // stack que ira ejecutando la logica comentada en el javadoc (arribita)
		
		int currentlyInnterItemSize = vector.getInnerItemSize(); // elementos que tiene la expresion RPN
		int i = 0; // de 0
		for (i = 0; i < currentlyInnterItemSize; i++) { // hasta el numero de elementos de la RPN
			String element = vector.getEle(i).toString(); // elemento del vector
			
			Matcher matcher = regexSum.matcher(element);
			if (matcher.find()) { // ahora realizamos parseDouble porque en Vector no trabajabamos con object			
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString()); // sacamos el primer elemento
				Double do2 = Double.parseDouble(stackEvaluador.pop().toString()); // sacamos el segundo elemento
				
				acumulador = do2+do1; // evaluamos
				stackEvaluador.push(acumulador); // enviamos la evaluacion al stack
			}
			
			// matcher = regexSubstract.matcher(elemento);
			if (element.equals("-")) { // si ocupamos la regex puede dar error porque entre un -12.5 y un - no diferencia
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				Double do2 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = do2-do1;
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexDivision.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				Double do2 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = do2/do1;
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexMulti.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				Double do2 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = do2*do1;
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexMenosUnitario.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = do1*-1;
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexRaizCuadrada.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = Math.sqrt(do1);
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexExponente.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				Double do2 = Double.parseDouble(stackEvaluador.pop().toString());
				
				acumulador = Math.pow(do2, do1);
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexSeno.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				do1 = do1 * (Math.PI/180); // convertion from degrees to radians
				
				acumulador = Math.sin(do1);
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexCoseno.matcher(element);
			if (matcher.find()) {
				Double do1 = Double.parseDouble(stackEvaluador.pop().toString());
				do1 = do1 * (Math.PI/180); // convertion from degrees to radians
				
				acumulador = Math.cos(do1);
				stackEvaluador.push(acumulador);
			}
			
			matcher = regexNumber.matcher(element);
			if (matcher.find())
				stackEvaluador.push(element);
		}
		
		return Double.parseDouble(stackEvaluador.pop().toString());
	}
}

/*
@Deprecated // Incluso numeros negativos hace match
private static Pattern regexSubstract = Pattern.compile("\\-"); // en grupos TODO: \\- se usa para not incluso, no solo para resta
*/