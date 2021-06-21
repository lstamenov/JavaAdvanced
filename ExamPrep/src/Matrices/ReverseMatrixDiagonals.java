package Matrices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] params = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = fillMatrix(params[0], scanner);

        for (int i = matrix.length - 1; i >= 0; i++) {
            for (int j = matrix.length - 1; j >= i; j++) {
                System.out.print(matrix[j][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int param, Scanner scanner) {
        int[][] matrix = new int[param][];
        for (int i = 0; i < param; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
