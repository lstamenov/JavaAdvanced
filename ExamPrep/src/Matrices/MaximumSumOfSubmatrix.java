package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] details = Arrays.stream(scanner.nextLine().split("[,]\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = fillMatrix(details[0], details[1], scanner);

        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestSubMatrix = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int[][] subMatrix = findMatrix(i, j, matrix);
                int sumOfSubMatrix = findSumOfMatrix(subMatrix);
                if (sumOfSubMatrix > biggestSum){
                    biggestSum = sumOfSubMatrix;
                    biggestSubMatrix = subMatrix;
                }
            }
        }

        print(biggestSubMatrix);
        System.out.println(biggestSum);
    }

    private static void print(int[][] biggestSubMatrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(biggestSubMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findMatrix(int row, int col, int[][] matrix) {
        int[][] subMatrix = new int[2][2];

        int subMatrixRows = 0;
        int subMatrixCols = 0;

        for (int i = row; i < row + 2; i++) {
            for (int j = col; j < col + 2; j++) {
                subMatrix[subMatrixRows][subMatrixCols++] = matrix[i][j];
            }
            subMatrixCols = 0;
            subMatrixRows++;
        }
        return subMatrix;
    }

    private static int findSumOfMatrix(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
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
