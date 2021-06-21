package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] details = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[details[0]][details[1]];
        StringBuilder start = new StringBuilder("aaa");

        for (int i = 0; i < details[0]; i++) {
            for (int j = 0; j < details[1]; j++) {
                matrix[i][j] = start.toString();
                start.setCharAt(1, (char) (start.charAt(1) + 1));
            }
            char newChar = (char) (start.charAt(0) + 1);
            start.setCharAt(0, newChar);
            start.setCharAt(1, newChar);
            start.setCharAt(2, newChar);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
