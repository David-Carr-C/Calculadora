package com.calculadora.test;

import com.calculadora.model.OperationTokenizer;
import com.vector.Vector;

public class TestOperationRokenizer {
	public static void main(String[] args) {
		Vector vector = OperationTokenizer.tokenizer("1+2+3-4-5*6*7/8/9");
		for (int i = 0; i < vector.getInnerItemSize(); i++) {
			System.out.print(vector.getEle(i) + " , ");
		}
		System.out.print("\n");
		System.out.println(vector);
	}
}
