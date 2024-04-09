package logica;

import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import interfaz.VentanaJuego;
import objeto.Matriz;

public class LogicaMatriz {
	private Keys keyInstance;
	private Random random;
	
	public Matriz generarMatriz (Integer dimension) {
		return new Matriz (dimension);
	}
	
	public boolean isGameOver(Matriz m) {
		boolean game = false;
		if (cantCeldasVacias(m) == m.getMatLength() || hayMovimientosPosibles(m)) {
			JOptionPane.showMessageDialog(null,"DERROTA");
			game = true;
		}else if(celda2048(m)) {
			JOptionPane.showMessageDialog(null,"VICTORIA");
			game = true;
		}
		return game;
	}
//GENERA LAS FICHAS EN TIEMPO REAL 
	private void generarFichas (Matriz m) {
		int celdasVacias= cantCeldasVacias(m);
		if (celdasVacias == 0) {
			return;
		}else {
		int indice = random.nextInt(celdasVacias)+1;
		celdasVacias = 0;
		
		for (int row = 0; row < m.getMatLength(); row++ ) {
			for (int col = 0 ; col <m.getCuadricula()[row].length;col++) {
				celdasVacias++;
				if (celdasVacias == indice) {
					int valor = (random.nextDouble() < 0.9) ? 2 : 4;
					m.getCuadricula()[row][col]=valor;
					return;
				}
			}
		}
		
		
		}
	}
//MOVER FICHAS (debo seguir modificando para que reciba los movimientos)
	private void moveTiles (Matriz m) { //Mover Fichas 
		boolean moved = false;
		switch(direction) {
		case KeyEvent.VK_UP:
			moved = keyInstance.moveUp(m.getCuadricula(),moved);
			break;
		case KeyEvent.VK_DOWN:
			moved = keyInstance.moveDown(m.getCuadricula(),moved);
			break;
		case KeyEvent.VK_LEFT:
			moved = keyInstance.moveLeft(m.getCuadricula(),moved);
			break;
		case KeyEvent.VK_RIGHT:
			moved = keyInstance.moveRight(m.getCuadricula(),moved);
			break;
		}
		if (moved) {
			generarFichas(m);
			if (isGameOver(m)) {
				return;
			}
		}

	}

	
	private int cantCeldasVacias (Matriz m) {
		int cantVacias = 0;
		for (int row = 0; row < m.getMatLength(); row++ ) {
			for (int col = 0 ; col <m.getCuadricula()[row].length;col++) {
				if (m.getCuadricula()[row][col]==0) {
					cantVacias++;
				}
			}
		}
		return cantVacias;
	}
	private boolean celda2048(Matriz m) {
		boolean terminated= false;
		for (int row = 0; row < m.getMatLength(); row++ ) {
			for (int col = 0 ; col <m.getCuadricula()[row].length;col++) {
				if (m.getCuadricula()[row][col]==2048) {
					terminated = true; 
				}
			}
			
	}
		return terminated;
}
//VERIFICA SI HAY MOVIMIENTOS POSIBLES RESTANTES EN EL JUEGO, TRUE SI HAY ESPACIO EN EL TABLERO O SI HAY 2 NUMEROS ADYACENTES QUE SON IGUALES. 
	private boolean hayMovimientosPosibles(Matriz m) {
		for (int row = 0; row < m.getMatLength(); row++ ) {
			for (int col = 0 ; col <m.getCuadricula()[row].length;col++) {
	            if (m.getCuadricula()[row][col] == 0) {
	                return true;
	            }
	            if (row > 0 && m.getCuadricula()[row - 1][col] == m.getCuadricula()[row][col]) {
	                return true;
	            }
	            if (row <m.getCuadricula().length - 1 && m.getCuadricula()[row + 1][col] == m.getCuadricula()[row][col]) {
	                return true;
	            }
	            if (col > 0 && m.getCuadricula()[row][col - 1] == m.getCuadricula()[row][col]) {
	                return true;
	            }
	            if (col < m.getCuadricula()[0].length - 1 && m.getCuadricula()[row][col + 1] == m.getCuadricula()[row][col]) {
	                return true;
	            }
	        }
	    }
	    return false; 
	}
//OTRA FORMA 	
//	int valor = (random.nextDouble() < 0.9) ? 2 : 4;
//	do {
//		fila = random.nextInt(4);
//		col = random.nextInt(4);
//	}while (matTablero[fila][col]!= 0 ); //tablero.Lugar == null
//	matTablero[fila][col]= valor;
	
//	private void combinarFichas(int fila, int col, int newFila, int newCol) {
//	int actualValor = matTablero [fila][col];
//	matTablero [fila][col]= 0;
//	matTablero [newFila][newCol]*=2; 
//	if (isGameOver()) {
//		JOptionPane.showMessageDialog(this,"Game Over","2048",JOptionPane.INFORMATION_MESSAGE);
//	}else {
//	generarFichas();
//	}
//}
}



