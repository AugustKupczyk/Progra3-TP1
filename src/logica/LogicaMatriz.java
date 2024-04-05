package logica;

import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import interfaz.VentanaJuego;

public class LogicaMatriz {
	private Integer [][] matTablero; //TENDRIA QUE CONTENER LOS LABELS
	private Random random;
	private VentanaJuego tablero;
	private Keys keyInstance;
	private Integer dimension;
	
	public LogicaMatriz (int dimension) {
		this.dimension=4;
		tablero = new VentanaJuego();
		keyInstance = new Keys(dimension);
		matTablero = new Integer [dimension][dimension]; 
	}
	
	private void generarFichas () {
		int celdasVacias= cantCeldasVacias();
		if (celdasVacias == 0) {
			return;
		}else {
		int indice = random.nextInt(celdasVacias)+1;
		celdasVacias = 0;
		
		for (int row = 0; row < matTablero.length; row++ ) {
			for (int col = 0 ; col <matTablero[0].length;col++) {
				celdasVacias++;
				if (celdasVacias == indice) {
					int valor = (random.nextDouble() < 0.9) ? 2 : 4;
					matTablero[row][col]=valor;
					return;
				}
			}
		}
		
		
		}
	}
	private boolean moveTiles (int direction) { //Mover Fichas 
		boolean moved = false;
		switch(direction) {
		case KeyEvent.VK_UP:
			moved = keyInstance.moveUp(matTablero,moved);
			break;
		case KeyEvent.VK_DOWN:
			moved = keyInstance.moveDown(matTablero,moved);
			break;
		case KeyEvent.VK_LEFT:
			moved = keyInstance.moveLeft(matTablero,moved);
			break;
		case KeyEvent.VK_RIGHT:
			moved = keyInstance.moveRight(matTablero,moved);
			break;
		}
		if (moved) {
			generarFichas();
			if (isGameOver()) {
				JOptionPane.showMessageDialog(this, "GameOver","2048");
			}
		}
	}
	private void combinarFichas(int fila, int col, int newFila, int newCol) {
		int actualValor = matTablero [fila][col];
		matTablero [fila][col]= 0;
		matTablero [newFila][newCol]*=2; 
		
		if (matTablero[newFila][newCol]==2048) {
			isGameOver();
		}
		generarFichas();
		
	}
//	private boolean isGameOver() {
//		return matTablero.gano()||matTablero.perdio();
//	}
	private int cantCeldasVacias () {
		int cantVacias = 0;
		for (int row=0; row < matTablero.length; row++) {
			for (int col = 0; col < matTablero.length; col++ ) {
				if (matTablero[row][col]==0) {
					cantVacias++;
				}
			}
		}
		return cantVacias;
	}
//OTRA FORMA 	
//	int valor = (random.nextDouble() < 0.9) ? 2 : 4;
//	do {
//		fila = random.nextInt(4);
//		col = random.nextInt(4);
//	}while (matTablero[fila][col]!= 0 ); //tablero.Lugar == null
//	matTablero[fila][col]= valor;
}



