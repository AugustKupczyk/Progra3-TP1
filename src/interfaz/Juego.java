package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Juego {

	private JFrame frame;
	private JPanel panelJuego;
	private JButton[][] gridButtons;
	private JLabel scoreLabel;
	private JButton restartButton;

	public Juego() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("2048");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		panelJuego = new JPanel(new GridLayout(4, 4));
		panelJuego.setBackground(new Color(139, 69, 19));
		gridButtons = new JButton[4][4];

		// Crear y agregar los botones de la cuadrícula
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				gridButtons[i][j] = new JButton();
				panelJuego.add(gridButtons[i][j]);
			}
		}

		JButton square = new JButton();
		square.setBorder(new LineBorder(Color.BLACK)); // Borde negro para separar los cuadrados

	

		// Crear y agregar botones de dirección
		JButton upButton = new JButton("↑");
		JButton downButton = new JButton("↓");
		JButton leftButton = new JButton("←");
		JButton rightButton = new JButton("→");

		// Crear y agregar la etiqueta de puntuación
		scoreLabel = new JLabel("Puntuación: 0");

		// Crear y agregar el botón de reinicio
		restartButton = new JButton("Reiniciar");

		// Agregar los componentes al frame
		frame.add(panelJuego, BorderLayout.CENTER);
		JPanel controlPanel = new JPanel(new FlowLayout());
		controlPanel.add(upButton);
		controlPanel.add(downButton);
		controlPanel.add(leftButton);
		controlPanel.add(rightButton);
		controlPanel.add(scoreLabel);
		controlPanel.add(restartButton);
		frame.add(controlPanel, BorderLayout.SOUTH);

		// Configurar el tamaño y mostrar la ventana
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Juego();
			}
		});
	}
}
