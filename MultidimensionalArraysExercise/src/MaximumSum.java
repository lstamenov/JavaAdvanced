import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = fillMatrix(scanner, rows);
        int biggestSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row][col + 2] + matrix[row + 1][col]
                        + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] +matrix[row + 2][col + 1]
                        + matrix[row + 2][col + 2];
                if (sum > biggestSum){
                    biggestSum = sum;
                    subMatrix = getCurrentSubMatrix(row, col, matrix);
                }
            }
        }

        System.out.println("Sum = " + biggestSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getCurrentSubMatrix(int row, int col, int[][] matrix) {
        int[][] subMatrix = new int[3][3];
        int rowsCount = 0;
        int colsCount = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
               subMatrix[rowsCount][colsCount] = matrix[i][j];
               colsCount++;
            }
            colsCount = 0;
            rowsCount++;
        }
        return subMatrix;
    }

    private static int[][] fillMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
