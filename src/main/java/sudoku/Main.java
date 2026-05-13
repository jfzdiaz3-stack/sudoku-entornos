package sudoku;

public class Main {
    public static void main(String[] args) {

        SudokuGame game = new SudokuGame(Difficulty.EASY);

        int[][] board = game.getBoard();

        System.out.println("Sudoku generado:");
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println("\n¿Está completo? " + game.isComplete());
    }
}
