public class SudokuSolver {
    private static final int GRID_SIZE = 9;
    private static final int EMPTY = 0;

    /**
     * Función principal que resuelve el Sudoku usando backtracking
     * @param arr - La matriz 9x9 del Sudoku (0 representa celdas vacías)
     * @return true si se encontró una solución, false en caso contrario
     */
    public static boolean solveSudoku(int[][] arr) {
        // Buscar la primera celda vacía
        int[] location = new int[2]; // [fila, columna]

        // Si no hay más celdas vacías, el Sudoku está resuelto
        if (!findEmptyLocation(arr, location)) {
            return true;
        }

        int row = location[0];
        int col = location[1];

        // Probar números del 1 al 9
        for (int num = 1; num <= 9; num++) {
            // Verificar si es seguro colocar este número
            if (isNumberSafe(arr, row, col, num)) {
                // Hacer la elección: colocar el número
                arr[row][col] = num;

                // Recursión: intentar resolver el resto del Sudoku
                if (solveSudoku(arr)) {
                    return true;
                }

                // Backtrack: si no funcionó, quitar el número
                arr[row][col] = EMPTY;
            }
        }

        // Si ningún número funciona, retornar false
        return false;
    }

    /**
     * Busca la primera celda vacía en el tablero
     * @param arr - La matriz del Sudoku
     * @param location - Array que almacenará las coordenadas [fila, columna]
     * @return true si encuentra una celda vacía, false si no hay más
     */
    private static boolean findEmptyLocation(int[][] arr, int[] location) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (arr[row][col] == EMPTY) {
                    location[0] = row;
                    location[1] = col;
                    return true;
                }
            }
        }
        return false; // No hay celdas vacías
    }

    /**
     * Verifica si es seguro colocar un número en una posición específica
     * @param arr - La matriz del Sudoku
     * @param row - Fila donde queremos colocar el número
     * @param col - Columna donde queremos colocar el número
     * @param num - El número que queremos colocar
     * @return true si es seguro, false en caso contrario
     */
    private static boolean isNumberSafe(int[][] arr, int row, int col, int num) {
        // Verificar que el número no esté en la fila
        if (usedInRow(arr, row, num)) {
            return false;
        }

        // Verificar que el número no esté en la columna
        if (usedInColumn(arr, col, num)) {
            return false;
        }

        // Verificar que el número no esté en el subcuadro 3x3
        if (usedInBox(arr, row - row % 3, col - col % 3, num)) {
            return false;
        }

        return true;
    }

    /**
     * Verifica si un número ya está usado en una fila específica
     */
    private static boolean usedInRow(int[][] arr, int row, int num) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (arr[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un número ya está usado en una columna específica
     */
    private static boolean usedInColumn(int[][] arr, int col, int num) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (arr[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un número ya está usado en un subcuadro 3x3
     * @param arr - La matriz del Sudoku
     * @param boxStartRow - Fila inicial del subcuadro
     * @param boxStartCol - Columna inicial del subcuadro
     * @param num - El número a verificar
     */
    private static boolean usedInBox(int[][] arr, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (arr[row + boxStartRow][col + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Función para imprimir el tablero de Sudoku
     */
    public static void printSudoku(int[][] arr) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Método principal para probar el solucionador
     */
    public static void main(String[] args) {
        // Ejemplo de Sudoku (0 representa celdas vacías)
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Sudoku original:");
        printSudoku(sudoku);

        if (solveSudoku(sudoku)) {
            System.out.println("¡Sudoku resuelto!");
            printSudoku(sudoku);
        } else {
            System.out.println("No se pudo resolver este Sudoku.");
        }

        // Ejemplo adicional con más explicación paso a paso
        System.out.println("\n" + "=".repeat(50));
        System.out.println("EXPLICACIÓN DEL ALGORITMO:");
        System.out.println("=".repeat(50));

        System.out.println("1. Buscar primera celda vacía (valor 0)");
        System.out.println("2. Probar números del 1 al 9");
        System.out.println("3. Para cada número, verificar:");
        System.out.println("   - No está en la misma fila");
        System.out.println("   - No está en la misma columna");
        System.out.println("   - No está en el mismo subcuadro 3x3");
        System.out.println("4. Si es válido:");
        System.out.println("   - Colocar el número");
        System.out.println("   - Recursión: resolver el resto");
        System.out.println("   - Si no funciona: BACKTRACK (quitar número)");
        System.out.println("5. Si ningún número funciona: retornar false");
        System.out.println("6. Si no hay más celdas vacías: ¡RESUELTO!");
    }
}

/**
 * CLASE ADICIONAL: Versión con contador de pasos para entender mejor el proceso
 */
class SudokuSolverWithSteps {
    private static final int GRID_SIZE = 9;
    private static final int EMPTY = 0;
    private static int stepCount = 0;
    private static int backtrackCount = 0;

    public static boolean solveSudokuWithSteps(int[][] arr) {
        int[] location = new int[2];

        if (!findEmptyLocation(arr, location)) {
            return true;
        }

        int row = location[0];
        int col = location[1];

        for (int num = 1; num <= 9; num++) {
            stepCount++;
            System.out.println("Paso " + stepCount + ": Probando " + num +
                    " en posición (" + row + ", " + col + ")");

            if (isNumberSafe(arr, row, col, num)) {
                System.out.println("  ✓ Número " + num + " es válido");
                arr[row][col] = num;

                if (solveSudokuWithSteps(arr)) {
                    return true;
                }

                backtrackCount++;
                System.out.println("  ✗ BACKTRACK #" + backtrackCount +
                        ": Quitando " + num + " de (" + row + ", " + col + ")");
                arr[row][col] = EMPTY;
            } else {
                System.out.println("  ✗ Número " + num + " no es válido");
            }
        }

        return false;
    }

    // Métodos auxiliares iguales que en la clase principal...
    private static boolean findEmptyLocation(int[][] arr, int[] location) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (arr[row][col] == EMPTY) {
                    location[0] = row;
                    location[1] = col;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isNumberSafe(int[][] arr, int row, int col, int num) {
        return !usedInRow(arr, row, num) &&
                !usedInColumn(arr, col, num) &&
                !usedInBox(arr, row - row % 3, col - col % 3, num);
    }

    private static boolean usedInRow(int[][] arr, int row, int num) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (arr[row][col] == num) return true;
        }
        return false;
    }

    private static boolean usedInColumn(int[][] arr, int col, int num) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (arr[row][col] == num) return true;
        }
        return false;
    }

    private static boolean usedInBox(int[][] arr, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (arr[row + boxStartRow][col + boxStartCol] == num) return true;
            }
        }
        return false;
    }
}
