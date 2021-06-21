import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int maxLength = -1;
        while (!input.equals("END")){
            words.add(input);
            if (input.length() > maxLength){
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }
        char[][] matrix = new char[words.size()][maxLength];

        for (int i = 0; i < words.size() + i; i++) {
            String word = words.remove(0);
            for (int j = 0; j < maxLength; j++) {
                if (word.length() > j)
                    matrix[i][j] = word.charAt(j);
                else
                    matrix[i][j] = ' ';
            }
        }
        int columns = matrix.length;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(command);
        int angle = 0;
        if (matcher.find())
            angle = Integer.parseInt(matcher.group());
        switch (angle) {
            case 90 -> matrix = rotateMatrix(angle, matrix.length, maxLength, matrix);
            case 180 -> matrix = rotateMatrix(angle, matrix.length, maxLength, matrix);
            case 270 -> {
                matrix = rotateMatrix(90, matrix.length, maxLength, matrix);
                matrix = rotateMatrix(angle, matrix.length, columns, matrix);
            }
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(int i, int rows, int cols, char[][] matrix) {
        char[][] newMatrix = new char[0][];
        if (i == 90){
            newMatrix = new char[cols][rows];
            int rowsCount = rows - 1;
            for (int j = 0; j < newMatrix.length; j++) {
                for (int k = 0; k < rows; k++) {
                    char c = matrix[rowsCount][j];
                    newMatrix[j][k] = c;
                    rowsCount--;
                }
                rowsCount = rows -1;
            }
        }else if (i == 270){
            newMatrix = new char[rows][cols];
            int oldRows = rows - 1;
            int oldCols = cols - 1;
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    newMatrix[j][k] = matrix[oldRows][oldCols];
                    oldCols--;
                }
                oldRows--;
                oldCols = cols -1;
            }
        }else if (i == 180){
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols / 2; k++) {
                    char temp = matrix[j][k];
                    matrix[j][k] = matrix[j][(cols - 1) - k];
                    matrix[j][(cols - 1) - k] = temp;
                }
            }
            for (int j = 0; j < rows / 2; j++) {
                char[] temp = matrix[j];
                matrix[j] = matrix[(rows - 1) - j];
                matrix[(rows - 1) - j] = temp;
            }
            newMatrix = matrix;
        }
        return newMatrix;
    }
}
