import java.util.Scanner;
public class MatrixRotation {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for the matrix:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for the matrix:");
        int cols = scanner.nextInt();
        
        int[][] inputMatrix = readMatrixInput(rows, cols, scanner);
        System.out.println("Input Matrix:");
        displayMatrix(inputMatrix);
        
        int[][] outputMatrix = applyCustomLogic(inputMatrix);
        System.out.println("\nOutput Matrix:");
        displayMatrix(outputMatrix);
        
        scanner.close();
    }

    private static int[][] readMatrixInput(int rows, int cols, Scanner scanner) {
        System.out.println("Enter elements for the matrix:");
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

private static int[][] applyCustomLogic(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] finalMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % 2 == 0) {
                    finalMatrix[i][j] = matrix[i][j] + 2;
                } else {
                    finalMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return finalMatrix;
    }
private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}