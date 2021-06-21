package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillMatrix(scanner, size);

        int primary = getPrimaryDiagonal(matrix);
        int secondary = getSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primary - secondary));
    }

    private static int getSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[matrix.length - 1 - i][i];
        }
        return sum;
    }

    private static int getPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[][] fillMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
