
import java.util.Arrays;
import java.util.Scanner;

public class WrongValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] wrongValueDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueDimensions[0]][wrongValueDimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue){
                    matrix[i][j] = getSumOfNearestNumbers(matrix, i, j, wrongValue);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSumOfNearestNumbers(int[][] matrix, int rows, int cols, int wrongValue) {
        int sum = 0;
        if (isValidDimension(rows - 1, cols, matrix)){
            if (matrix[rows -1][cols] != wrongValue) {
                sum += matrix[rows - 1][cols];
            }
        }

        if (isValidDimension(rows + 1, cols, matrix)){
            if (matrix[rows + 1][cols] != wrongValue) {
                sum += matrix[rows + 1][cols];
            }
        }

        if (isValidDimension(rows, cols - 1, matrix)){
            if (matrix[rows][cols - 1] != wrongValue) {
                sum += matrix[rows][cols - 1];
            }
        }

        if (isValidDimension(rows, cols + 1, matrix)){
            if (matrix[rows][cols + 1] != wrongValue) {
                sum += matrix[rows][cols + 1];
            }
        }

        return sum;
    }

    private static boolean isValidDimension(int rows, int cols, int[][] matrix) {
        return  (rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[rows].length);
    }
}
