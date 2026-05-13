package sudoku;

public class SudokuGame {

    private Board board;
    private int[][] initialGrid;

    public SudokuGame(Difficulty difficulty) {
        SudokuGenerator generator = new SudokuGenerator();
        int[][] generated = generator.generate(difficulty);

        board = new Board();
        initialGrid = new int[9][9];

        // Copiar el tablero generado al Board y guardar copia inicial
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board.getGrid()[r][c] = generated[r][c];
                initialGrid[r][c] = generated[r][c];
            }
        }
    }

    public boolean makeMove(int row, int col, int value) {
        // No permitir modificar las casillas originales
        if (initialGrid[row][col] != 0) {
            return false;
        }

        if (board.isValidMove(row, col, value)) {
            board.getGrid()[row][col] = value;
            return true;
        }

        return false;
    }

    public boolean isComplete() {
        return board.isComplete();
    }

    public int[][] getBoard() {
        return board.getGrid();
    }

    public int[][] getInitialGrid() {
        return initialGrid;
    }
}
