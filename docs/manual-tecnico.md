# Manual Técnico

## Tecnologías
- Java 17
- Swing
- Maven

## Estructura del código
- Board: matriz 9x9 del tablero.
- SudokuGame: lógica del juego.
- SudokuGenerator: genera tableros válidos.
- SudokuSolver: resuelve el tablero.
- SudokuUI: interfaz gráfica.
- Main: punto de entrada.

## Compilación
mvn clean compile

## Ejecución
mvn exec:java

## Pruebas
mvn test
