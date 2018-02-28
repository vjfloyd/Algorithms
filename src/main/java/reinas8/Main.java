/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas8;

/**
 *
 * @author vjrojasb
 */
public class Main {
 
    //tamano filas y columnas
    public static final int TAMANO_TABLERO = 8;
    boolean[][] tablero;
    //Indicate an empty square
    public static final boolean EMPTY = false;
    //Indicate a square which containing a queen 
    public static final boolean esta_reina = true;
    //Number of moves 
    public static final int MOVES = 4;
    //Horizontal moves
    int[] horizontal;
    //Vertical moves
    int[] vertical;
    public int nReinas = 0;

    public static void main(String[] s) {
        Main main = new Main();
        main.insertarReina(0);
        main.mostrarTablero();
    }

    public Main() {
        //El constructor crea el tablero inicial
        tablero = new boolean[TAMANO_TABLERO][TAMANO_TABLERO];
        for (int row = 0; row < tablero.length; row++) {
            for (int col = 0; col < tablero[row].length; col++) {
                tablero[row][col] = EMPTY;
            }
        }

        horizontal = new int[MOVES];
        vertical = new int[MOVES];
        // up right 
        horizontal[0] = -1;
        vertical[0] = 1;
        // down left 
        horizontal[1] = 1;
        vertical[1] = -1;
        // up left 
        horizontal[2] = -1;
        vertical[2] = -1;
        // down right 
        horizontal[3] = 1;
        vertical[3] = 1;
    }

    public boolean insertarReina(int column) {
        if (column >= TAMANO_TABLERO) {
            return true;
        } else {
            boolean queenPlaced = false;
            int row = 0;
            while (!queenPlaced && row < TAMANO_TABLERO) {
                if (numeroAtaques(row, column)) {
                    ++row;
                }// end 
                else {
                    setReina(row, column);

                    queenPlaced = insertarReina(column + 1);
                    if (!queenPlaced) {
                        removerReina(row, column);
                        ++row;
                    } 
                }
            }
            return queenPlaced;
        }
    }

    private void removerReina(int row, int column) {
        tablero[row][column] = EMPTY;
        System.out.printf("Remover reina de [%d][%d]\n", row, column);
        --nReinas;
    }

    private void setReina(int row, int column) {
        tablero[row][column] = esta_reina;
        System.out.printf("Colocar reina en [%d][%d]\n", row, column);
        ++nReinas;
    }

    public boolean numeroAtaques(int row, int col) {
        boolean condition = false; // check row 
        for (int column = 0; column < TAMANO_TABLERO; column++) {
            if ((tablero[row][column] == true)) {
                condition = true;
            }
        } // check column 
        for (int row_ = 0; row_ < tablero.length; row_++) {
            if (tablero[row_][col] == true) {
                condition = true;
            }
        } // check diagonal 
        for (int row_ = row, col_ = col; row_ >= 0 && col_ < 8; row_ += horizontal[0], col_ += vertical[0]) {
            if (tablero[row_][col_] == true) {
                condition = true;
            }
        }
        for (int row_ = row, col_ = col; row_ < 8 && col_ >= 0; row_ += horizontal[1], col_ += vertical[1]) {
            if (tablero[row_][col_] == true) {
                condition = true;
            }
        }
        for (int row_ = row, col_ = col; row_ >= 0 && col_ >= 0; row_ += horizontal[2], col_ += vertical[2]) {
            if (tablero[row_][col_] == true) {
                condition = true;
            }
        }
        for (int row_ = row, col_ = col; row_ < 8 && col_ < 8; row_ += horizontal[3], col_ += vertical[3]) {
            if (tablero[row_][col_] == true) {
                condition = true;
            }
        }
        return condition;
    }

    public void mostrarTablero() {
        int counter = 0;
        for (int row = 0; row < tablero.length; row++) {
            for (int col = 0; col < tablero[row].length; col++) {
                if (tablero[row][col] == true) {
                    System.out.printf("|%s|", "x");
                    counter++;
                } else {
                    System.out.printf("|%s|", "o");
                }
            }
            System.out.println();
        }
        System.out.printf("%d Número de reinas \n", counter);
    }
}
