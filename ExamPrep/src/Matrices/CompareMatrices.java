package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMatrixRowsCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = fillMatrix(scanner, firstMatrixRowsCols);

        int[] secondMatrixRowsCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] secondMatrix = fillMatrix(scanner, secondMatrixRowsCols);

        String result = compareMatrices(firstMatrix, secondMatrix) ? "equal" : "not equal";
        System.out.println(result);
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length == secondMatrix.length) {
            for (int i = 0; i < firstMatrix.length; i++) {
                if (firstMatrix[i].length == secondMatrix[i].length){
                    for (int j = 0; j < firstMatrix.length; j++) {
                        if (firstMatrix[i][j] != secondMatrix[i][j]){
                            return false;
                        }
                    }
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    private static int[][] fillMatrix(Scanner scanner, int[] matrixRowsCols) {
        int[][] matrix = new int[matrixRowsCols[0]][matrixRowsCols[1]];
        for (int i = 0; i < matrixRowsCols[0]; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrixRowsCols[1]; j++) {
                matrix[i][j] = row[j];
            }
        }
        return matrix;
    }
}
