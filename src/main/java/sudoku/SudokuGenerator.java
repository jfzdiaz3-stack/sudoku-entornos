package sudoku;

import java.util.Random;

public class SudokuGenerator {

    private Random random = new Random();

    public int[][] generate(Difficulty difficulty) {
        int[][] board = new int[9][9];

        fillBoard(board);

        int clues = switch (difficulty) {
            case EASY -> 40;
            case MEDIUM -> 32;
            case HARD -> 25;
        };

        removeCells(board, 81 - clues);

        return board;
    }

    private boolean fillBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (fillBoard(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int value) {
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == value) return false;
        }
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == value) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (board[r][c] == value) return false;
            }
        }

        return true;
    }

    private void removeCells(int[][] board, int toRemove) {
        while (toRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);

            if (board[row][col] != 0) {
                board[row][col] = 0;
                toRemove--;
            }
        }
    }
}
