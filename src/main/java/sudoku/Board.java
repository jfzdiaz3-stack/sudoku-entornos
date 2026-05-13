package sudoku;

public class Board {

    private int[][] grid = new int[9][9];

    public boolean isValidMove(int row, int col, int value) {
        if (value < 1 || value > 9) {
            return false;
        }

        for (int c = 0; c < 9; c++) {
            if (grid[row][c] == value) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (grid[r][col] == value) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (grid[r][c] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isComplete() {
    // 1. Comprobar que no hay ceros
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            int value = grid[row][col];

            if (value == 0) {
                return false;
            }

            // 2. Comprobar que cada valor cumple las reglas
            // Para evitar que se detecte a sí mismo, lo quitamos temporalmente
            grid[row][col] = 0;

            if (!isValidMove(row, col, value)) {
                grid[row][col] = value; // restaurar
                return false;
            }

            grid[row][col] = value; // restaurar
        }
    }

    return true;
}


    public int[][] getGrid() {
        return grid;
    }
}
