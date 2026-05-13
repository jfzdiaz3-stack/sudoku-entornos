# UML del Proyecto

## Diagrama de clases

```mermaid
classDiagram
    class Board {
        -int[][] grid
        +getGrid()
        +getCell()
        +setCell()
    }

    class SudokuGame {
        -Board board
        -int mistakes
        -Difficulty difficulty
        +makeMove()
        +solve()
        +isComplete()
        +isGameOver()
    }

    class SudokuGenerator {
        +generate()
        -fillBoard()
        -removeCells()
    }

    class SudokuSolver {
        +solve()
        -isValid()
    }

    class SudokuUI {
        -SudokuGame game
        -JTextField[][] cells
        +startNewGame()
        +loadBoard()
    }

    Board --> SudokuGame
    SudokuGenerator --> SudokuGame
    SudokuSolver --> SudokuGame
    SudokuUI --> SudokuGame
