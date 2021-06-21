import java.util.Arrays;
import java.util.Scanner;

public class IntersectionsOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] secondMatrix = readMatrix(scanner, rows, cols);
        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] thirdMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]){
                    thirdMatrix[i][j] = secondMatrix[i][j];
                }else {
                    thirdMatrix[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static char[][] readMatrix(Scanner scanner, int rows, int cols){
         char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] ch = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ch[j].charAt(0);
            }
        }
        return matrix;
    }
}
