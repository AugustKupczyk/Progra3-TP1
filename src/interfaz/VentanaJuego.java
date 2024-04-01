package interfaz;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaJuego {

	private JFrame frame;
	private JPanel cardPanel;
	private JPanel panelJuego;
	private CardLayout cardLayout;

	public VentanaJuego() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("2048");
		frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

		ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
		frame.setIconImage(icon.getImage());

		// Creamos el panel que contendrá los paneles intercambiables
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		cardPanel.setBounds(0, 0, 434, 261); // Ajusta el tamaño según sea necesario
		frame.getContentPane().add(cardPanel);

		// Panel principal con la imagen de fondo
		ImagenPanel panelInicio = new ImagenPanel("/2048-game.png");
		panelInicio.setLayout(null);
		cardPanel.add(panelInicio, "panelInicio");

		// Panel para el juego
		panelJuego = new JPanel();

		panelJuego.setLayout(null);
		cardPanel.add(panelJuego, "panelJuego");

		// Panel para las instrucciones
		JPanel panelInstrucciones = new JPanel();
		panelInstrucciones.setLayout(null);
		cardPanel.add(panelInstrucciones, "panelInstrucciones");

		JLabel lblNewLabel = new JLabel("BIENVENID@ A:");
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(105, 63, 233, 42);
		panelInicio.add(lblNewLabel);

		// Botones y elementos para el panel de instrucciones
		JLabel lblInstrucciones = new JLabel("Instrucciones del juego:");
		lblInstrucciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInstrucciones.setBounds(20, 20, 200, 20);
		panelInstrucciones.add(lblInstrucciones);

		JLabel lblTextoInstrucciones = new JLabel("Aquí van las instrucciones del juego...");
		lblTextoInstrucciones.setBounds(20, 50, 400, 150);
		panelInstrucciones.add(lblTextoInstrucciones);

		// Botón para volver al panel principal
		JButton botonVolverInicio = new JButton("Volver al inicio");
		botonVolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panelInicio");
			}
		});
		botonVolverInicio.setBounds(150, 210, 150, 30);
		panelInstrucciones.add(botonVolverInicio);

		// Botón "Jugar"
		JButton botonJugar = new JButton("Jugar!");
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la clase Juego
				Juego juego = new Juego();

				// Cerrar la ventana principal
				frame.dispose();
			}
		});
		botonJugar.setBounds(100, 170, 120, 30);
		botonJugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelInicio.add(botonJugar);

		// Botón "Como Jugar"
		JButton botonComoJugar = new JButton("Como jugar?");
		botonComoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panelInstrucciones");
			}
		});
		botonComoJugar.setBounds(230, 170, 120, 30);
		botonComoJugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelInicio.add(botonComoJugar);

		// Botón "Salir"
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(150, 210, 120, 30);
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelInicio.add(botonSalir);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego window = new VentanaJuego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
