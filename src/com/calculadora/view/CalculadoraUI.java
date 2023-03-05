package com.calculadora.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;

/**
 * Crea la ventana principal de la aplicacion
 * @author David-Carr-C
 * @version 1.0
 */
public class CalculadoraUI extends JFrame {
	private static final long serialVersionUID = -6162995291678880223L; // travel network
	private JPanel contentPane; // panel interior
	private JTextField textField; // campo de texto superior

	/**
	 * Constructor e inicializador de la ventana
	 */
	public CalculadoraUI() {
		super("Calculadora"); // titulo
		
		initComponents(); // inicia los componentes de la ventana
		
		super.setSize(450,365); // tamaño de la ventana
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acabar la app al cerrar
		super.setLocationRelativeTo(null); // se centra la ventana al eliminar la locacion relativa a algo
		super.setVisible(true); // funciona si se llama asi
	}
	
	private void initComponents() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // se crea un panel dentro del frame
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK); // black background

		this.setContentPane(contentPane); // con border layout para ocupar toda la ventana
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField(); // en la parte norte se pone el campo de texto
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK));
		
		TouchPanel panel = new TouchPanel(textField); // y en el centro todo nuestro panel creado
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
