package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = fillMatrix(rowsCols);


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int[] params = Arrays.stream(input.split("\\s+"))
            .mapToInt(Integer::parseInt).toArray();
            int row = params[0];
            int col = params[1];
            int radius = params[2];


            int startingColumn = Math.max(row - radius, 0);
            int endColumn = Math.min(matrix.length - 1, row + radius);

            for (int i = row - 1; i >= startingColumn; i--) {
                if (startingColumn < matrix[i].length) {
                    matrix[i] = cutColumn(matrix[i], col);
                }
            }
            for (int i = row + 1; i <= endColumn; i++) {
                matrix[i] = cutColumn(matrix[i], col);
            }

            startingColumn = Math.max(0, col - radius);
            endColumn = Math.min(matrix[row].length - 1, col + radius);

            if (startingColumn == 0 && endColumn == matrix[row].length){
                matrix[row] = null;
            }else {
                int[] newRow = new int[matrix[row].length -
                        (endColumn - startingColumn  + 1)];
                int count = 0;
                for (int i = 0; i < newRow.length; i++) {
                    if (count >= startingColumn && count <= endColumn){
                        count++;
                        i--;
                    }else {
                        newRow[i] = matrix[row][count++];
                    }
                }
                matrix[row] = newRow;
            }

            input = scanner.nextLine();
        }
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int[] cutColumn(int[] matrix, int col) {
        int count = 0;
        int[] newRow = new int[matrix.length - 1];
        for (int i = 0; i < newRow.length; i++) {
            if (count == col){
                count++;
                i--;
            }else {
                newRow[i] = matrix[count++];
            }
        }
        return newRow;
    }

    private static int[][] fillMatrix(int[] rowsCols) {
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }
}
