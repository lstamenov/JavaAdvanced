
import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        StringBuilder currString = new StringBuilder("aaa");
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char newChar = (char) (currString.charAt(0) + j);
                currString.setCharAt(1, newChar);
                matrix[i][j] = currString.toString();
            }
            char newChar = (char) (currString.charAt(0) + 1);
            for (int j = 0; j < currString.length(); j++) {
                currString.setCharAt(j, newChar);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
