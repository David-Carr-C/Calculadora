package com.calculadora.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.calculadora.controller.OperationExecute;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Panel que mostrará las teclas y sus interacciones con el input del usuario
 * @author David-Carr-C
 * @version 1.1
 */
public class TouchPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 4692863409844660474L; // default serial version
	private JTextField text; // campo de texto
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPoint, btnCos, // some buttons
	btnPlus, btnSubstract, btnMultiplication, btnDivision, btnPower, btnSquareRoot, btnClear, btnEquals;
	private JButton btnParenthesisApertura, btnParenthesisCierre, btnSeno, btnMenosUnitario;
	
	public TouchPanel(JTextField text) {
		this.text = text; // se pasa el campo de texto aqui para poder cambiarlo y editarlo
		setBounds(100, 100, 450, 300); // limites
		this.setBorder(new EmptyBorder(5, 5, 5, 5)); // border
		this.setBackground(Color.BLACK);

		// Filas, columnas, espacio horizontal, espacio vertical
		this.setLayout(new GridLayout(4, 6, 10, 10)); // grid
		/*
		 * Conforme se van agregando botones aparecen verticalmente, pero en cuanto se tienen todas las
		 * posiciones cubieras se editan horizontalmente, al final es horizontal
		 * 
		 * ¡Cuidado con no excederse de elementos porque crea nuevas columnas!
		 */
		btn1 = new JButton("1");
		btn1.addActionListener(this); // accion al clickear
		btn1.setBackground(Color.ORANGE);
		btn1.setBorder(new LineBorder(Color.BLACK));
		btn1.setFocusPainted(false); //TODO: stylized
		this.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this); // accion al clickear
		btn2.setBackground(Color.ORANGE);
		btn2.setBorder(new LineBorder(Color.BLACK));
		btn2.setFocusPainted(false);
		this.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this); // accion al clickear
		btn3.setBackground(Color.ORANGE);
		btn3.setBorder(new LineBorder(Color.BLACK));
		btn3.setFocusPainted(false);
		this.add(btn3);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(this); // accion al clickear
		btnPlus.setFocusPainted(false);
		btnPlus.setBorder(new LineBorder(Color.BLACK));
		btnPlus.setBackground(Color.ORANGE);
		this.add(btnPlus);
		
		btnSubstract = new JButton("-");
		btnSubstract.addActionListener(this); // accion al clickear
		btnSubstract.setFocusPainted(false);
		btnSubstract.setBorder(new LineBorder(Color.BLACK));
		btnSubstract.setBackground(Color.ORANGE);
		this.add(btnSubstract);

		btnPower = new JButton("^");
		btnPower.addActionListener(this); // accion al clickear
		btnPower.setFocusPainted(false);
		btnPower.setBorder(new LineBorder(Color.BLACK));
		btnPower.setBackground(Color.ORANGE);
		this.add(btnPower);
		
		btn4 = new JButton("4");
		btn4.addActionListener(this); // accion al clickear
		btn4.setFocusPainted(false);
		btn4.setBorder(new LineBorder(Color.BLACK));
		btn4.setBackground(Color.ORANGE);
		this.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this); // accion al clickear
		btn5.setFocusPainted(false);
		btn5.setBorder(new LineBorder(Color.BLACK));
		btn5.setBackground(Color.ORANGE);
		this.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this); // accion al clickear
		btn6.setFocusPainted(false);
		btn6.setBorder(new LineBorder(Color.BLACK));
		btn6.setBackground(Color.ORANGE);
		this.add(btn6);
		
		btnMultiplication = new JButton("*");
		btnMultiplication.addActionListener(this); // accion al clickear
		btnMultiplication.setFocusPainted(false);
		btnMultiplication.setBorder(new LineBorder(Color.BLACK));
		btnMultiplication.setBackground(Color.ORANGE);
		this.add(btnMultiplication);//
		
		btnDivision = new JButton("/");
		btnDivision.addActionListener(this); // accion al clickear
		btnDivision.setFocusPainted(false);
		btnDivision.setBorder(new LineBorder(Color.BLACK));
		btnDivision.setBackground(Color.ORANGE);
		this.add(btnDivision);
		
		btnSquareRoot = new JButton("√");
		btnSquareRoot.addActionListener(this); // accion al clickear
		btnSquareRoot.setFocusPainted(false);
		btnSquareRoot.setBorder(new LineBorder(Color.BLACK));
		btnSquareRoot.setBackground(Color.ORANGE);
		this.add(btnSquareRoot);
		
		btn7 = new JButton("7");
		btn7.addActionListener(this); // accion al clickear
		btn7.setFocusPainted(false);
		btn7.setBorder(new LineBorder(Color.BLACK));
		btn7.setBackground(Color.ORANGE);
		this.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(this); // accion al clickear
		btn8.setFocusPainted(false);
		btn8.setBorder(new LineBorder(Color.BLACK));
		btn8.setBackground(Color.ORANGE);
		this.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this); // accion al clickear
		btn9.setFocusPainted(false);
		btn9.setBorder(new LineBorder(Color.BLACK));
		btn9.setBackground(Color.ORANGE);
		this.add(btn9);
		
		btnParenthesisApertura = new JButton("(");
		btnParenthesisApertura.addActionListener(this);
		btnParenthesisApertura.setFocusPainted(false);
		btnParenthesisApertura.setBorder(new LineBorder(Color.BLACK));
		btnParenthesisApertura.setBackground(Color.ORANGE);
		this.add(btnParenthesisApertura);
		
		
		btnParenthesisCierre = new JButton(")");
		btnParenthesisCierre.addActionListener(this);
		btnParenthesisCierre.setFocusPainted(false);
		btnParenthesisCierre.setBorder(new LineBorder(Color.BLACK));
		btnParenthesisCierre.setBackground(Color.ORANGE);
		this.add(btnParenthesisCierre);
		
		btnMenosUnitario = new JButton("(-)");
		btnMenosUnitario.addActionListener(this);
		btnMenosUnitario.setFocusPainted(false);
		btnMenosUnitario.setBorder(new LineBorder(Color.BLACK));
		btnMenosUnitario.setBackground(Color.ORANGE);
		this.add(btnMenosUnitario);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this); // accion al clickear
		btn0.setFocusPainted(false);
		btn0.setBorder(new LineBorder(Color.BLACK));
		btn0.setBackground(Color.ORANGE);
		this.add(btn0);
		
		btnPoint = new JButton(".");
		btnPoint.addActionListener(this); // accion al clickear
		btnPoint.setFocusPainted(false);
		btnPoint.setBorder(new LineBorder(Color.BLACK));
		btnPoint.setBackground(Color.ORANGE);
		this.add(btnPoint);
		
		btnClear = new JButton("C");
		btnClear.addActionListener(this); // accion al clickear
		btnClear.setFocusPainted(false);
		btnClear.setBorder(new LineBorder(Color.BLACK));
		btnClear.setBackground(Color.ORANGE);
		this.add(btnClear);
		
		btnSeno = new JButton("sen");
		btnSeno.addActionListener(this);
		btnSeno.setFocusPainted(false);
		btnSeno.setBorder(new LineBorder(Color.BLACK));
		btnSeno.setBackground(Color.ORANGE);
		this.add(btnSeno);
		
		btnCos = new JButton("cos");
		btnCos.addActionListener(this); // accion al clickear
		btnCos.setFocusPainted(false);
		btnCos.setBorder(new LineBorder(Color.BLACK));
		btnCos.setBackground(Color.ORANGE);
		this.add(btnCos);
		
		btnEquals = new JButton("=");
		btnEquals.addActionListener(this); // accion al clickear
		btnEquals.setFocusPainted(false);
		btnEquals.setBorder(new LineBorder(Color.BLACK));
		btnEquals.setBackground(Color.ORANGE);
		this.add(btnEquals);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textFromCalculator = text.getText();
		
		if (e.getSource()==btn0) {
			textFromCalculator += "0";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn1) {
			textFromCalculator += "1";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn2) {
			textFromCalculator += "2";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn3) {
			textFromCalculator += "3";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn4) {
			textFromCalculator += "4";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn5) {
			textFromCalculator += "5";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn6) {
			textFromCalculator += "6";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn7) {
			textFromCalculator += "7";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn8) {
			textFromCalculator += "8";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btn9) {
			textFromCalculator += "9";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnCos) {
			textFromCalculator += " cos";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnPoint) {
			textFromCalculator += ".";
			text.setText(textFromCalculator);
		}
			
		
		if (e.getSource()==btnPlus) {
			textFromCalculator += " + ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnSubstract) {
			textFromCalculator += " - ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnMultiplication) {
			textFromCalculator += " * ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnDivision) {
			textFromCalculator += " / ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnPower) {
			textFromCalculator += " ^ ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnSquareRoot) {
			textFromCalculator += " sqrt";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnClear) {
			text.setText("");
		}
		
		if (e.getSource()==btnParenthesisApertura) {
			textFromCalculator += "( ";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnParenthesisCierre) {
			textFromCalculator += " )";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnSeno) {
			textFromCalculator += " sen";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnMenosUnitario) {
			textFromCalculator = " (_"+textFromCalculator+")";
			text.setText(textFromCalculator);
		}
		
		if (e.getSource()==btnEquals) {
			try {
				textFromCalculator = OperationExecute.executeCalculadora(textFromCalculator);
				text.setText(textFromCalculator);
				
			} catch (Exception exception) { // arroja el error como ventana de dialogo
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
			
		}
		
	}
	
	

}
