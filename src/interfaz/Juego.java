package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego {

    private JFrame frame;
    private JPanel panelJuego;

    /**
     * Create the application.
     */
    public Juego() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelJuego = new JPanel();
        frame.getContentPane().add(panelJuego);

        JButton btnNewButton = new JButton("Panel de Juego");
        btnNewButton.setBounds(157, 110, 117, 29);
        panelJuego.add(btnNewButton);

        frame.setVisible(true);
    }

    // Método para mostrar la ventana de juego
    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
