import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int rows = rowsCols[0];
        int cols = rowsCols[1];
        int biggestSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int currSum =
                        matrix[i][j] + matrix[i + 1][j]
                        + matrix[i][j + 1] + matrix[i + 1][j + 1];
                if (currSum > biggestSum){
                    biggestSum = currSum;
                    subMatrix[0][0] = matrix[i][j];
                    subMatrix[1][0] = matrix[i + 1][j];
                    subMatrix[0][1] = matrix[i][j + 1];
                    subMatrix[1][1] = matrix[i + 1][j + 1];
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
