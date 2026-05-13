# UML - Sudoku

```mermaid
classDiagram
    class Board {
        -int[][] grid
        +boolean isValidMove(int row, int col, int value)
        +boolean isComplete()
        +int[][] getGrid()
    }

    class SudokuGenerator {
        +int[][] generateFullBoard()
        +int[][] removeCells(int[][] board, Difficulty difficulty)
    }

    class SudokuGame {
        -Board board
        -int mistakes
        -long startTime
        +start(Difficulty difficulty)
        +solve()
        +int getMistakes()
    }

    class Difficulty {
    }

    SudokuGame --> Board
    SudokuGame --> SudokuGenerator
