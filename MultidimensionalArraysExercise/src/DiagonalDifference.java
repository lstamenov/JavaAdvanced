
import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][rows];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int i = 0; i < rows; i++) {
            firstDiagonalSum += matrix[i][i];
        }
        for (int i = rows -1; i >= 0; i--) {
            secondDiagonalSum += matrix[i][(rows - i) - 1];
        }
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
