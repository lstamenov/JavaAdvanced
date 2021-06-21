package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] details = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[details[0]][details[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] command = input.split("\\s+");
            if (isValidCommand(command, matrix)){
                int fRow = Integer.parseInt(command[1]);
                int fCol = Integer.parseInt(command[2]);
                int sRow = Integer.parseInt(command[3]);
                int sCol = Integer.parseInt(command[4]);

                String temp = matrix[fRow][fCol];
                matrix[fRow][fCol] = matrix[sRow][sCol];
                matrix[sRow][sCol] = temp;

                print(matrix);
            }else {
                System.out.println("Invalid output!");
            }
            input = scanner.nextLine();
        }
    }

    private static void print(String[][] matrix) {
        for (String[] row : matrix) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String[] command, String[][] matrix) {
        if (command[0].equals("swap") && command.length == 5){
            int fRow = Integer.parseInt(command[1]);
            int fCol = Integer.parseInt(command[2]);
            int sRow = Integer.parseInt(command[3]);
            int sCol = Integer.parseInt(command[4]);

            if (fRow >= 0 && fRow < matrix.length &&
                    sRow >= 0 && sRow < matrix.length){
                return sCol >= 0 && sCol < matrix[sRow].length &&
                        fCol >= 0 && fCol < matrix[fRow].length;
            }else {
                return false;
            }
        }
        return false;
    }
}
