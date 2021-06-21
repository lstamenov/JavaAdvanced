package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(rows, scanner);
        int[] numberPosition = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int number = matrix[numberPosition[0]][numberPosition[1]];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number){
                    matrix[i][j] = findSumOfClosestIntegers(matrix, i, j);
                }
            }
        }

        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findSumOfClosestIntegers(int[][] matrix, int row, int col) {
        int sum = 0;
        if (row > 0){
            sum += matrix[row - 1][col];
        }
        if (row < matrix.length - 1){
            sum += matrix[row + 1][col];
        }

        if (col > 0){
            sum += matrix[row][col - 1];
        }
        if (col < matrix[row].length - 1){
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static int[][] fillMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
