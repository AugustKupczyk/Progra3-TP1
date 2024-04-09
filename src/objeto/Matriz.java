package objeto;

import java.util.Random;

public class Matriz {
    private int dimension;
    private int[][] cuadricula;
    private Random rand;

    public Matriz(int dimension) {
        this.dimension = dimension;
        this.cuadricula = new int[dimension][dimension];
        this.rand = new Random();
        inicializarMatriz();
    }

    public int[][] getCuadricula() {
        return cuadricula;
    }

    public int getDimension() {
        return dimension;
    }

    private void inicializarMatriz() {
        // Inicializar todas las celdas con ceros (o vacías)
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cuadricula[i][j] = 0;
            }
        }
        // Agregar un número inicial aleatorio
        agregarNumeroAleatorio();
    }

    public void agregarNumeroAleatorio() {
        // Encuentra una posición aleatoria vacía en el tablero y coloca un 2 o un 4
        int fila, columna;
        do {
            fila = rand.nextInt(dimension);
            columna = rand.nextInt(dimension);
        } while (cuadricula[fila][columna] != 0);
        cuadricula[fila][columna] = (rand.nextInt(2) + 1) * 2; // Puede ser 2 o 4
    }
}
