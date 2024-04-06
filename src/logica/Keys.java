package logica;

public class Keys extends LogicaMatriz {
	public Keys(int dimension) {
		super(dimension);
		// TODO Auto-generated constructor stub
	}

	public boolean moveRight(Integer [][] mat , boolean moved) {
		for(int row=0;row < mat.length;row++) {
			for (int col = mat[0].length-2; col >= 0;col--) {
				if (mat [row][col]!=0) {
					int k = col+1;
					while (k <mat.length && mat [row][k]==0) {
						k++;
					}
					if (k < mat.length && mat [row][k]==mat [row][col]) {
						mat [row][k]*=2 ; 
						mat [row][col]= 0 ; 
						moved = true;
					}else if (k-1 != col) {
						mat [row][k-1]=mat [row][col]; 
						mat [row][col]= 0 ; 
						moved = true;
					}
				}
			}
		}
		return moved; 
	}
	public boolean moveLeft(Integer [][] mat,boolean moved) {
		for (int row = 0; row < mat.length; row++) {
	        for (int col = 1; col < mat[0].length; col++) { 
				if (mat [row][col]!=0) {
					int k = col-1;
					 while (k >= 0 && mat[row][k] == 0) { // Cambio aquí
		                    k--;
		                }
					 if (k >= 0 && mat[row][k] == mat[row][col]) { // Cambio aquí
		                    mat[row][k] *= 2;
		                    mat[row][col] = 0;
		                    moved = true;
		                } else if (k + 1 != col) { // Cambio aquí
		                    mat[row][k + 1] = mat[row][col]; // Cambio aquí
		                    mat[row][col] = 0;
		                    moved = true;
				}
			}
		}
	}
		return moved;
	}
	public boolean moveDown(Integer [][] mat,boolean moved) {
		for (int col = 0; col < mat.length ; col++) {
			for (int row = mat[0].length-2 ; row >= 0 ; row--){
				if (mat[row][col] != 0) {
					int k = row + 1;
					while (k < mat.length && mat [k][col]==0) {
						if (k < mat.length && mat[k][col] == mat[row][col]) {
		                    mat[k][col] *= 2;
		                    mat[row][col] = 0;
		                    moved = true;
		                } else if (k - 1 != row) {
		                    mat[k - 1][col] = mat[row][col];
		                    mat[row][col] = 0;
		                    moved = true;
					}
				}
			}
		}
	}
		return moved;
}
	public boolean moveUp(Integer [][] mat,boolean moved) {
	    for (int col = 0; col < mat.length; col++) {
	        for (int row = 1; row < mat[0].length; row++) {
	            if (mat[row][col] != 0) {
	                int k = row - 1;
	                while (k >= 0 && mat[k][col] == 0) {
	                    k--;
	                }
	                if (k >= 0 && mat[k][col] == mat[row][col]) {
	                    mat[k][col] *= 2;
	                    mat[row][col] = 0;
	                    moved = true;
	                } else if (k + 1 != row) {
	                    mat[k + 1][col] = mat[row][col];
	                    mat[row][col] = 0;
	                    moved = true;
	                }
	            }
	        }
	    }
	    return moved;
	}
}
