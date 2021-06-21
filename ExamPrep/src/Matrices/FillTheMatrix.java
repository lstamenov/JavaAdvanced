package Matrices;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        int[][] ints = fillMatrix(pattern, scanner, numberOfRows);
        print(ints);
    }

    private static int[][] fillMatrix(String pattern, Scanner scanner, int numberOfRows) {
        int[][] matrix = new int[numberOfRows][numberOfRows];
        int count = 1;
        if (pattern.equals("A")){
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfRows; j++) {
                    matrix[j][i] = count++;
                }
            }
        }else {
            for (int i = 0; i < numberOfRows; i++) {
                if (i % 2 == 0){
                    for (int j = 0; j < numberOfRows; j++) {
                        matrix[j][i] = count++;
                    }
                }else {
                    for (int j = numberOfRows - 1; j >= 0; j--) {
                        matrix[j][i] = count++;
                    }
                }
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
