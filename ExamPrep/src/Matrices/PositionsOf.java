package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] details = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = details[0];
        int cols = details[1];
        int[][] matrix = fillMatrix(scanner, rows, cols);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number){
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }

        String result = isFound ? "" : "not found";
        System.out.println(result);
    }

    private static int[][] fillMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] ints = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ints[j];
            }
        }
        return matrix;
    }
}
