package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] details = Arrays.stream(scanner.nextLine().split("[,]\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(details[0]);
        System.out.println(details[1]);

        int[][] matrix = fillMatrix(details[0], details[1], scanner);

        System.out.println(sumMatrixElements(matrix));
    }

    private static int sumMatrixElements(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] details = Arrays.stream(scanner.nextLine().split("[,]\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = details[j];
            }
        }
        return matrix;
    }
}
