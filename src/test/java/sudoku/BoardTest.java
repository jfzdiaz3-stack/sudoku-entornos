package sudoku;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testValidMove() {
        Board board = new Board();
        assertTrue(board.isValidMove(0, 0, 5));
    }

    @Test
    public void testInvalidRow() {
        Board board = new Board();
        board.getGrid()[0][1] = 5;
        assertFalse(board.isValidMove(0, 0, 5));
    }

    @Test
    public void testInvalidColumn() {
        Board board = new Board();
        board.getGrid()[1][0] = 5;
        assertFalse(board.isValidMove(0, 0, 5));
    }

    @Test
    public void testInvalidSubgrid() {
        Board board = new Board();
        board.getGrid()[1][1] = 5;
        assertFalse(board.isValidMove(0, 0, 5));
    }

    @Test
    public void testIncompleteBoard() {
        Board board = new Board();
        assertFalse(board.isComplete());
    }

    @Test
    public void testCompleteBoard() {
        Board board = new Board();

        int[][] solved = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                board.getGrid()[r][c] = solved[r][c];
            }
        }

        assertTrue(board.isComplete());
    }

    @Test
    public void testGeneratorCreatesValidBoard() {
        SudokuGenerator gen = new SudokuGenerator();
        int[][] board = gen.generate(Difficulty.EASY);

        boolean hasNumbers = false;
        boolean hasZeros = false;

        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) hasZeros = true;
                if (cell != 0) hasNumbers = true;
            }
        }

        assertTrue(hasNumbers);
        assertTrue(hasZeros);
    }
}
