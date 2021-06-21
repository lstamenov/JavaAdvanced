package Matrices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String input = scanner.nextLine();
        int biggestLength = 0;
        while (!input.equals("END")){
            if (input.length() > biggestLength){
                biggestLength = input.length();
            }
            words.add(input);
            input = scanner.nextLine();
        }
        int degrees = Integer.parseInt(scanner.nextLine());
        char[][] matrix;
        switch (degrees) {
            case 0 -> {
                matrix = normalFill(words, biggestLength);
                print(matrix);
            }
            case 90 -> {
                matrix = fillNinety(words, biggestLength);
                print(matrix);
            }
            case 180 -> {
                matrix = normalFill(words, biggestLength);
                reverseNormalMatrix(matrix);
                print(matrix);
            }
            case 270 -> {
                matrix = fillNinety(words, biggestLength);
                reverseNinety(matrix);
                print(matrix);

            }
        }

    }

    private static void reverseNinety(char[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            char[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length / 2; j++) {
//                char temp = matrix[j][i];
//                matrix[j][i] = matrix[matrix.length - 1 - j][i];
//                matrix[matrix.length - 1 - j][i] = temp;
//            }
//        }
    }

    private static char[][] fillNinety(List<String> words, int biggestLength) {
        char[][] matrix = new char[biggestLength][words.size()];
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(words.size() - 1 - i);
            for (int j = 0; j < word.length(); j++) {
                matrix[j][i] = word.charAt(j);
            }
        }
        return matrix;
    }

    private static void reverseNormalMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            char[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                char temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }

    private static void print(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char character : arr) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    private static char[][] normalFill(List<String> words, int biggestLength) {
        char[][] matrix = new char[words.size()][biggestLength];
        for (int i = 0; i < matrix.length; i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                matrix[i][j] = word.charAt(j);
            }
        }
        return matrix;
    }
}
