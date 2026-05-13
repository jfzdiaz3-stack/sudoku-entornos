# Arquitectura del Proyecto

## Capas
- Modelo: Board
- Lógica: SudokuGame, SudokuGenerator, SudokuSolver
- Interfaz: SudokuUI
- Entrada: Main

## Flujo
1. Main inicia SudokuUI.
2. El usuario pulsa “Nuevo”.
3. SudokuUI crea SudokuGame.
4. SudokuGame usa SudokuGenerator para crear el tablero.
5. El usuario introduce números.
6. SudokuGame valida los movimientos.
7. Si se pulsa “Resolver”, SudokuGame usa SudokuSolver.
