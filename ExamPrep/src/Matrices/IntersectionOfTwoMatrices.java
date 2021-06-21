package Matrices;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrixA = fillMatrix(scanner, rows, cols);
        char[][] matrixB = fillMatrix(scanner, rows, cols);

        char[][] matrixC = fillMatrixWithCommonElements(matrixA, matrixB);

        print(matrixC);
    }

    private static void print(char[][] matrixC) {
        for (char[] chars : matrixC) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrixWithCommonElements(char[][] matrixA, char[][] matrixB) {
        char[][] matrixC = new char[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = matrixA[i][j] == matrixB[i][j] ? matrixB[i][j] : '*';
            }
        }
        return matrixC;
    }

    private static char[][] fillMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String chars = scanner.nextLine();
            chars = chars.replace(" ", "");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = chars.charAt(j);
            }
        }
        return matrix;
    }
}
