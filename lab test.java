import java.util.Scanner;
public class MatrixRotation {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.println(x:"Enter the number of rows for the matrix:");
int rows = scanner.nextInt();

System.out.println(x:"Enter the number of columns for the matrix:");
int cols = scanner.nextInt();

int[][] inputMatrix = readMatrixInput(rows, cols, scanner);
System.out.println(x:"Input Matrix:");
displayMatrix(inputMatrix);

int[][] outputMatrix = applyCustomLogic(inputmatrix);
System.out.println(x:"\nOutput Matrix:");
displayMatrix(outputmatrix);

scanner.close();
}

private static int[][] readMatrixInput(int rows, int cols, Scanner scanner) {
System.out.println("Enter elements for the matrix");
int[][] matrix = new int[rows][cols];
for (int i=0; i<rows; i++) {
for (int j=0; j<cols; j++) {
System.out.print("Matrix["+ (i + 1) + "][" + (j + 1) +"]: ");
matrix[i][j] = scanner.nextInt();
}
}
return matrix;
}

private static int[][] applyCustomLogic(int[][] matrix) {
int rows = matrix.length;
int cols = matrix[0].length;
int[][] finalmatrix = new int[rows][cols];
for (int i =0; i<rows; i++) {
for (int j = 0; j<cols; j++) {
if(matrix[i][j] %2 == 0) {
finalmatrix[i][j] =matrix[i][j] +2;
} else {
finalmatrix[i][j] =matrix[i][j];
}
}
}
return finalmatrix;
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