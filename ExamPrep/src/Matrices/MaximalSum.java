package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] details = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = fillMatrix(details[0], scanner);

        int biggestSum = Integer.MIN_VALUE;
        int[][] biggestMatrix = new int[3][];
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int[][] sub = getMatrix(i, j, matrix);
                int currentSum = getSum(sub);
                if (currentSum > biggestSum){
                    biggestSum = currentSum;
                    biggestMatrix = sub;
                }
            }
        }
        System.out.println("Biggest sum = " + biggestSum);
        for (int[] row : biggestMatrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] sub) {
        int sum = 0;
        for (int[] row : sub) {
            for (int col : row) {
                sum += col;
            }
        }
        return sum;
    }

    private static int[][] getMatrix(int row, int col, int[][] matrix) {
        int[][] sub = new int[3][3];
        int subRow = 0;
        int subCol = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sub[subRow][subCol++] = matrix[i][j];
            }
            subRow++;
            subCol = 0;
        }
        return sub;
    }

    private static int[][] fillMatrix(int detail, Scanner scanner) {
        int[][] matrix = new int[detail][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
